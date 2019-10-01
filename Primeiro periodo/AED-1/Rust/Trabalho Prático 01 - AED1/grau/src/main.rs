use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    print!("Digite um grau em fahrenheit: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Erro de leitura!");
    let grauf: f32 = input.trim().parse::<f32>().expect("Não foi possível converter valor em numero!");
    let grauc = 5.0/9.0 * (grauf - 32.0);
    println!("O grau em celsius é {:.2}°C", grauc);
}
