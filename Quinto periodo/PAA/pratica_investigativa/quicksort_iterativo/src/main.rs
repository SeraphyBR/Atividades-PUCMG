fn partition(vec: &mut [i32], esq: usize, dir: usize) -> usize {
    let pivo = vec[dir];
    let mut index = esq;

    for j in esq..dir {
        if vec[j] < pivo {
            vec.swap(j, index);
            index += 1;
        }
    }
    vec.swap(index, dir);

    index // retorna o pivo devidamente posicionado
}

fn quicksort_it(vec: &mut [i32]){
    // Criar um vetor auxiliar
    let mut stack: Vec<usize> = Vec::with_capacity(vec.len());

    // Coloca os valores iniciais de esq e dir;
    stack.push(0);
    stack.push(vec.len() - 1);

    let mut esq: usize;
    let mut dir: usize;
    let mut pivo: usize;

    while !stack.is_empty() {
        dir = stack.pop().unwrap();
        esq = stack.pop().unwrap();

        pivo = partition(vec, esq, dir);

        if pivo > 0 {
            // Se houverem elementos a esquerda do pivo
            if pivo - 1 > esq {
                stack.push(esq);
                stack.push(pivo - 1);
            }
        }
        // Se houverem elementos a direita do pivo
        if pivo + 1 < dir {
            stack.push(pivo + 1);
            stack.push(dir);
        }
    }
}

fn main() {
    let mut vec = vec![10,9,8,7,6,5,4,3,2,1];
    println!("{:?}",vec);
    quicksort_it(&mut vec);
    println!("{:?}",vec);
}
