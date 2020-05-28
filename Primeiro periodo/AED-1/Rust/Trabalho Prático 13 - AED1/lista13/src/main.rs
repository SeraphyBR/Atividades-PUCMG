use std::io;
use std::io::Write;

use human_panic::setup_panic;

mod triangulo;
use triangulo::{Triangulo, TrianguloType};

fn main() {
    setup_panic!();// Nice error message
    let mut tri: Vec<Triangulo> = Vec::with_capacity(100);
    menu(&mut tri);
}//Fim main()

fn menu(tri: &mut Vec<Triangulo>) {
    loop {
        println!("\n*** MENU DOS TRIANGULOS ***");
        println!("0 - Sair do programa");
        println!("1 - Adicionar um triângulo");
        println!("2 - Listar todos os Triângulos");
        println!("3 - Triângulos Iguais");
        println!("4 - Listar os triângulos de um determinado tipo");
        println!("5 - Verificar inconsistências");
        let opcao = read("-> ").chars().next().unwrap();
        match opcao {
            '0' => break,
            '1' => cria_triangulo(tri),
            '2' => mostra_triangulos(tri),
            '3' => triangulos_iguais(tri),
            '4' => lista_triangulos(tri, escolhe_tipo()),
            '5' => lista_triangulos_invalidos(tri),
            _ => println!("Opção invalida!"),
        }
    }
}//Fim menu()

fn cria_triangulo(tri: &mut Vec<Triangulo>) {
    if tri.len() < tri.capacity() {
        let a = loop {
            match read("\nDigite o lado A: ").trim().parse::<f32>() {
                Ok(a) => break a,
                Err(_) => {
                    println!("Valor inválido!");
                    continue;
                }
            }
        };
        let b = loop {
            match read("Digite o lado B: ").trim().parse::<f32>() {
                Ok(b) => break b,
                Err(_) => {
                    println!("Valor inválido!");
                    continue;
                }
            }
        };
        let c = loop {
            match read("Digite o lado C: ").trim().parse::<f32>() {
                Ok(c) => break c,
                Err(_) => {
                    println!("Valor inválido!");
                    continue;
                }
            }
        };
        tri.push(Triangulo::new(a, b, c));
        println!("Concluído!");
    } else {
        println!("Oops!... Limite foi alcançado!");
    }
}//Fim cria_triangulo()


fn mostra_triangulos(tri: &Vec<Triangulo>) {
    for (i, t) in tri.iter().enumerate() {
        let (a, b, c) = t.get_lados();
        println!("\nTriangulo {}:", i + 1);
        println!("Lado A: {}", a);
        println!("Lado B: {}", b);
        println!("Lado C: {}", c);
        println!("Perimetro: {}", t.perimetro());
    }
}//Fim mostra_triangulos()

fn triangulos_iguais(tri: &Vec<Triangulo>) {
    println!(
        "Deseja comparar com base em qual triangulo? [1..{}]",
        tri.len()
    );
    let op = loop {
        match read(": ").trim().parse::<usize>() {
            Ok(op) => {
                if op < 1 || op > tri.len() {
                    println!("Triangulo inexistente!\nDigite novamente");
                    continue;
                } else {
                    break op - 1;
                }
            }
            Err(_) => {
                println!("Oops! Não entendi, digite novamente.");
                continue;
            }
        }
    };
    let mut iguais = 0;
    for (i, t) in tri.iter().enumerate() {
        if op != i && tri[op].eh_igual(t) {
            iguais += 1;
        }
    }
    match iguais {
        0 => println!("Não há triangulos iguais a este!"),
        1 => println!("Tem um triangulo igual a este!"),
        _ => println!("Há {} triangulos iguais a este!", iguais),
    }
}//Fim triangulos_iguais()

fn lista_triangulos(tri: &Vec<Triangulo>, ty: TrianguloType) {
    for (i, t) in tri.iter().enumerate() {
        let (a, b, c) = t.get_lados();
        if Triangulo::eh_valido(a, b, c) && t.tipo() == ty {
            println!("\nTriangulo {:?} {}:", ty, i + 1);
            println!("Lado A: {}", a);
            println!("Lado B: {}", b);
            println!("Lado C: {}", c);
            println!("Perimetro: {}", t.perimetro());
        }
    }
}//Fim lista_triangulos()

fn lista_triangulos_invalidos(tri: &Vec<Triangulo>) {
    let mut invalidos = 0;
    for (i, t) in tri.iter().enumerate() {
        let (a, b, c) = t.get_lados();
        if !Triangulo::eh_valido(a, b, c) {
            println!("O triangulo {} é inválido!", i);
            invalidos += 1;
        }
    }
    if invalidos == 0 {
        println!("Não há casos de invalidez!");
    }
}

fn escolhe_tipo() -> TrianguloType {
    loop {
        println!("Qual o tipo de Triangulo?");
        println!("1=Equilátero; 2=Isóscele; 3=Escaleno");
        match read("=> ").chars().next().unwrap() {
            '1' => break TrianguloType::Equilatero,
            '2' => break TrianguloType::Isoscele,
            '3' => break TrianguloType::Escaleno,
            _ => println!("Opção invalida!"),
        }
    }
}//Fim lista_triangulos_invalidos()

fn read(msg: &str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin()
        .read_line(&mut input)
        .expect("Erro ao ler do teclado!");
    input
}//Fim read()
