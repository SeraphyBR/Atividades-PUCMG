use std::io;
use std::io::Write;

fn main() {
    let (mut x, mut termo_p1, mut razao, mut termos, mut valor, mut input);
    let mut divisiveis = 0;
    println!("Esse programa calcula o número de termos da P.A, que");
    println!("são divisíveis por X.");
    loop {
        x = read("Digite o valor de X: ").trim().parse::<i16>().unwrap();
        termo_p1 = read("Digite o primeiro termo da P.A: ").trim().parse::<f32>().unwrap();
        razao = read("Digite a razão: ").trim().parse::<f32>().unwrap();
        loop {
            termos = read("Digite o número de termos: ").trim().parse::<i32>().unwrap();
            if termos <=0 {println!("Valor inválido!")}
            else {break}
        }

        for i in 1..=termos {
            valor = termo_p1 + ((i - 1) as f32) * razao;
            println!("{}º -> {}", i,valor);
            if valor % x as f32 == 0.0 {divisiveis +=1 }
        }
        println!("A quantidade de termos que é divisível por {} é: {}", x, divisiveis);

        loop {
            input = read("Deseja fazer um novo calculo? [s/n]: ");
            match input.trim() {
                "s"|"n" => break,
                _ => println!("Opção inválida!"),
            }
        }
        if input.trim() == "n" {break}
    }
}

fn read(msg: &str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    return input;
}
