use ndarray::prelude::*;
use std::fmt;
use std::collections::VecDeque;

enum GrafoType {
    Comum,
    Orientado,
    Ponderado,
    OrientadoPonderado,
}

#[derive(Clone, PartialEq)]
enum Cor {
    Branco,
    Cinza,
    Preto,
}

pub struct Grafo {
    matriz_adj: Array2<i32>,
    num_vertices: usize,
    tipo: GrafoType,
}

#[allow(dead_code)]
impl Grafo {
    fn new(vertices: usize, t: GrafoType) -> Self {
        Grafo {
            matriz_adj: Array::from_elem((vertices,vertices), -1),
            num_vertices: vertices,
            tipo: t,
        }
    }

    pub fn comum(vertices: usize) -> Self {
        Grafo::new(vertices, GrafoType::Comum)
    }

    pub fn orientado(vertices: usize) -> Self {
        Grafo::new(vertices, GrafoType::Orientado)
    }

    pub fn ponderado(vertices: usize) -> Self {
        Grafo::new(vertices, GrafoType::Ponderado)
    }

    pub fn orientado_ponderado(vertices: usize) -> Self {
        Grafo::new(vertices, GrafoType::OrientadoPonderado)
    }

    pub fn add_conexao(&mut self, v1: usize, v2: usize){
        self.add_peso(v1, v2, 1)
    }

    pub fn add_peso(&mut self, v1: usize, v2: usize, peso: i32) {
        match self.tipo {
            GrafoType::Comum => {
                if v1 == v2 {
                    self.matriz_adj[(v1,v2)] = 2;
                }
                else {
                    self.matriz_adj[(v1,v2)] = 1;
                    self.matriz_adj[(v2,v1)] = 1;
                }
            },
            GrafoType::Ponderado => {
                self.matriz_adj[(v1,v2)] = peso;
                self.matriz_adj[(v2,v1)] = peso;
            },
            GrafoType::Orientado => {
                self.matriz_adj[(v1,v2)] = 1;
            },
            GrafoType::OrientadoPonderado => {
                self.matriz_adj[(v1,v2)] = peso;
            }
        }
    }//end add_conexao()

    pub fn del_conexao(&mut self, v1: usize, v2: usize){
        if v1 < self.num_vertices && v2 < self.num_vertices {
            match self.tipo {
                GrafoType::Orientado => {
                    self.matriz_adj[(v1,v2)] = -1;
                },
                GrafoType::OrientadoPonderado => {
                    self.matriz_adj[(v1,v2)] = -1;
                },
                _ => {
                    self.matriz_adj[(v1,v2)] = -1;
                    self.matriz_adj[(v2,v1)] = -1;
                },
            }
        }
    }//end del_conexao()

    pub fn get_conexao(&self, v1: usize, v2: usize) -> i32 {
        self.matriz_adj[(v1,v2)]
    }

    pub fn num_vertices(&self) -> usize {
        self.num_vertices
    }

    fn dfs_visit(&self, cor: &mut Vec<Cor>, v: usize, lcomp: &mut Vec<usize>){
        cor[v] = Cor::Cinza;
        lcomp.push(v);
        for i in 0..self.num_vertices {
            if self.matriz_adj[(i,v)] > -1 && cor[i] == Cor::Branco{
                self.dfs_visit(cor, i, lcomp);
            }
        }
        cor[v] = Cor::Preto;
    }

    // Uso do algoritmo de busca em busca profundidade
    // retorna um vetor contendo uma lista para cada componente
    // do grafo, essa lista contem o numero dos vetores pertencentes
    // ao componente.
    pub fn componentes(&self) -> Vec<Vec<usize>> {
        let mut componentes: Vec<Vec<usize>> = Vec::new();
        let mut lcomp: Vec<usize> = Vec::new();
        let mut cor: Vec<Cor> = vec![Cor::Branco; self.num_vertices];
        for v in 0..self.num_vertices {
            if cor[v] == Cor::Branco {
                self.dfs_visit(&mut cor, v, &mut lcomp);
                lcomp.sort_unstable();
                componentes.push(lcomp.clone());
                lcomp.clear();
            }
        }
        componentes
    }

    pub fn busca_largura(&self, v: usize) -> Vec<i32> {
        let mut dist: Vec<i32> = vec![i32::max_value(); self.num_vertices];
        let mut cor: Vec<Cor> = vec![Cor::Branco; self.num_vertices];
        let mut fila: VecDeque<usize> = VecDeque::new();
        dist[v] = 0;
        cor[v] = Cor::Cinza;
        fila.push_back(v);
        while !fila.is_empty() {
            let u = fila.pop_front().unwrap();
            for i in 0..self.num_vertices() {
                if self.matriz_adj[(u,i)] > -1 && cor[i] == Cor::Branco {
                    cor[i] = Cor::Cinza;
                    dist[i] = dist[u] + 1;
                    fila.push_back(i);
                }
            }
            cor[u] = Cor::Preto;
        }
        dist
    }

    pub fn grau_vertice(&self, v: usize) -> i32 {
        let iter = self.matriz_adj.row(v);
        let mut grau = 0;
        for i in iter {
            grau += i;
        }
        grau
    }

    // Um grafo G conexo possui caminho euleriano se e somente se ele tem
    // exatamente zero ou dois vértices de grau impar
    //fn tem_caminho_euleriano() -> bool {

    //}

    fn menor_nao_visitado(vec: &Vec<i32>, visitado: &Vec<i32>) -> usize {
        let mut indice = 0;
        let mut menor = i32::max_value();
        let mut i = 0;
        while i < vec.capacity() && i < visitado.capacity() {
            if visitado[i] != 1 && vec[i] < menor {
                menor = vec[i];
                indice = i;
            }
            i += 1;
        }
        indice
    }

    // Algoritmo de dijkstra que retorna a distancia até o ultimo vertice
    // visitado, retorna o maior valor de i32 caso não seja possível
    // percorrer o caminho.
    fn dijkstra_b(&mut self, caminho_unico: bool) -> i32 {
        let mut dist: Vec<i32> = vec![i32::max_value(); self.num_vertices];
        let mut pai: Vec<i32> = vec![-1; self.num_vertices];
        let mut visitado: Vec<i32> = vec![0; self.num_vertices];
        dist[0] = 0;
        visitado[0] = 1;
        let mut menor = 0;
        for _i in 0..self.num_vertices {
            for j in 0..self.num_vertices{
                if visitado[j] != 1 && j != menor && self.matriz_adj[(menor,j)] != -1 {
                    if dist[j] > dist[menor] + self.matriz_adj[(menor,j)] {
                        dist[j] = dist[menor] + self.matriz_adj[(menor,j)];
                        pai[j] = menor as i32;
                    }
                }
            }
            visitado[menor] = 1;
            menor = Grafo::menor_nao_visitado(&dist, &visitado);
        }

        if caminho_unico {
            let mut v = self.num_vertices - 1;
            while pai[v] != -1 {
                self.del_conexao(pai[v] as usize, v);
                v = pai[v] as usize;
            }
            if v != 0 {
                //Caso a volta não seja possivel
                return -1;
            }
        }

        match dist.last(){
            Some(x) => *x,
            None => i32::max_value(),
        }
    }//End dijkstra_b()

    pub fn dijkstra_unico(&mut self) -> i32 {
        self.dijkstra_b(true)
    }

    pub fn dijkstra(&mut self) -> i32 {
        self.dijkstra_b(false)
    }
}

impl fmt::Display for Grafo {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        for linha in self.matriz_adj.genrows() {
            for v in linha {
                write!(f, " {} ", v)?;
            }
            writeln!(f,"")?;
        }
        write!(f, "")
    }
}