use std::io;
use std::io::Write;
use std::f32;

fn main() {
    let mut input = String::new();
    print!("Digite o raio do circulo: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Oops...! Erro ao ler valor!");
    let raio: f32 = input.trim().parse::<f32>().expect("Isso não é um numero válido!");
    let area = f32::consts::PI * raio.powf(2.0);
    println!("A área do circulo é: {:.2}", area);
}
