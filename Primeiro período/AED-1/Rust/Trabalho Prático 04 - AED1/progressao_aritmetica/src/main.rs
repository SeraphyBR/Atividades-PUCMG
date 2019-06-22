use std::io;
use std::io::Write;

fn main() {
    let (mut termo_p1, mut razao, mut termos, mut valor, mut op);
    let mut divisiveis = 0;
    let mut x;
    println!("Esse programa calcula o número de termos da P.A, que");
    println!("são divisíveis por X.");
    loop {
        x = loop {
            match read("Digite o valor X: ").trim().parse::<i16>() {
                Ok(i) => break i,
                Err(_) => {println!("Isso não é um número inteiro\nTente novamente"); continue}
            }
        };

        termo_p1 = loop {
            match read("Digite o primeiro termo da P.A: ").trim().parse::<f32>() {
                Ok(i) => break i,
                Err(_) => {println!("Isso não é um número!\nTente novamente."); continue},
            }
        };

        razao = loop {
            match read("Digite a razão: ").trim().parse::<f32>() {
                Ok(i) => break i,
                Err(_) => {println!("Isso não é um número!\nTente novamente."); continue},
            }
        };

        termos = loop {
            match read("Digite o número de termos: ").trim().parse::<i32>() {
                Ok(i) => {
                    if i <= 0 {println!("Valor inválido!"); continue}
                    else {break i}
                },
                Err(_) => {println!("Isso não é um número inteiro!\nTente novamente."); continue},
            }
        };

        for i in 1..=termos {
            valor = termo_p1 + ((i - 1) as f32) * razao;
            println!("{}º -> {}", i,valor);
            if valor % f32::from(x) == 0.0 {divisiveis += 1}
        }
        println!("A quantidade de termos que é divisível por {} é: {}", x, divisiveis);

        loop {
            op = read("Deseja fazer um novo calculo? [s/n]: ");
            match op.trim() {
                "s"|"n" => break,
                _ => println!("Opção inválida!"),
            }
        }
        if op.trim() == "n" {break}
    }//Fim loop
}//Fim main

fn read(msg: &str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("não foi possível ler do teclado!");
    input
}//fim read
