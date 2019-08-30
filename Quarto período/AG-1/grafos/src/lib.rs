use ndarray::prelude::*;
use std::fmt;

pub struct Grafo {
    matriz_adj: Array2<u8>,
}

#[allow(dead_code)]
impl Grafo {
    fn new(&mut self, vertices: usize) -> Self {
        Grafo {
            matriz_adj: Array2::zeros((vertices,vertices)),
        }
    }

    fn add_conexao(&mut self, v1: usize, v2: usize) {
        if v1 == v2 {
            self.matriz_adj[(v1,v2)] = 2;
        }
        else {
            self.matriz_adj[(v1,v2)] = 1;
        }
    }

    fn num_componentes(&self) -> usize {
    }

    fn grau_vertice(&self, v: usize) -> u8 {
        let iter = self.matriz_adj.row(v);
        let mut grau = 0;
        for i in iter {
            grau += i;
        }
        grau
    }

    fn busca_profundidade(&self) -> Vec<usize> {

    }

    fn busca_largura(&self) -> Vec<usize> {

    }
}

impl fmt::Display for Grafo {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        writeln!(f, "")
    }
}