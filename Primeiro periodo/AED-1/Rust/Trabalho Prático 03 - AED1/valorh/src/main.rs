use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa calcula e escreve o valor de H,");
    println!("sendo H igual a: 1/100 + 1/97 + 1/91 + ...\n");
    print!("Digite a quantidade de termos a serem usados para calcular o valor de H:");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let termos = input.trim().parse::<i32>().unwrap();

    let mut h = 0.0;
    let mut num = 100;
    for _step in 0..termos {
        h += 1.0 / num as f32;
        num -= 3;
    }
    println!("O valor de H é: {}", h);

}
