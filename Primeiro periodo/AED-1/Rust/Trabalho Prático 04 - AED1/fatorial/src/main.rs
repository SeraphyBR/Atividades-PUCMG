use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa calcula o fatorial de um número.");
    println!("Digite um número negativo para encerrar o programa.");
    loop {
        print!("Digite um número inteiro: ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();
        let num = input.trim().parse::<i32>().unwrap();
        input.clear();
        if num < 0 {break}
        let mut fatorial = 1;
        for n in (1..=num).rev() {
            fatorial *= n;
        }
        println!("O fatorial de {} é: {}", num,fatorial);
    }
}
