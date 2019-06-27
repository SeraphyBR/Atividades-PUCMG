use std::io;
use std::io::Write;

mod triangulo;
use triangulo::Triangulo;

fn main() {
    let mut tri = [Triangulo::new_empty(); 5];
    for i in 0..5 {
        println!("Valores do Triangulo {}:", i + 1);
        tri[i] = loop {
            let lado1 = loop {
                match read("Digite o lado A: ").trim().parse::<f32>() {
                    Ok(a) => {
                        if a > 0.0 {break a}
                        else {println!("Valor inválido!\nTente novamente."); continue}
                    },
                    Err(_) => {println!("Isso não é um numero!\nTente novamente."); continue},
                }
            };
            let lado2 = loop {
                match read("Digite o lado B: ").trim().parse::<f32>() {
                    Ok(b) => {
                        if b > 0.0 {break b}
                        else {println!("Valor inválido!\nTente novamente."); continue}
                    },
                    Err(_) => {println!("Isso não é um numero!\nTente novamente."); continue},
                }
            };
            let lado3 = loop {
                match read("Digite o lado C: ").trim().parse::<f32>() {
                    Ok(c) => {
                        if c > 0.0 {break c}
                        else {println!("Valor inválido!\nTente novamente."); continue}
                    },
                    Err(_) => {println!("Isso não é um numero!\nTente novamente."); continue},
                }
            };
            if Triangulo::eh_valido(lado1, lado2, lado3) {
                break Triangulo::new(lado1, lado2, lado3)
            }
            else {
                println!("Os valores inseridos não correspondem a um Triangulo!");
                println!("Tente novamente.");
                continue
            }
        };
        println!("Tipo do Triangulo: {:?}", tri[i].tipo());
        println!("Deseja comparar quais triângulos? [1..5]");
        let op1 = loop {
            match read("a => ").trim().parse::<usize>() {
                Ok(a) => {
                    if a <= 5 && a >= 1 {break a}
                    else {println!("Opção inválida!\nTente novamente."); continue}
                },
                Err(_) => {println!("Isso não é um numero valido!\nTente novamente."); continue},
            }
        };
        let op2 = loop {
            match read("b => ").trim().parse::<usize>() {
                Ok(b) => {
                    if b <= 5 && b >= 1 {break b}
                    else {println!("Opção inválida!\nTente novamente."); continue}
                },
                Err(_) => {println!("Isso não é um numero valido!\nTente novamente."); continue},
            }
        };

        if tri[op1 - 1].eh_igual(&tri[op2 - 1]) {
            println!("São iguais");
        }
        else {println!("Não são iguais!")}

    }
}//Fim main

fn read(msg: &str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Erro ao ler do teclado!");
    input
}//Fim read
