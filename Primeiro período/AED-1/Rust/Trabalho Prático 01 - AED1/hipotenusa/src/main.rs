use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("O seguinte programa calcula a hipotenusa de um triângulo.");
    print!("Digite o primeiro cateto: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let cateto_a = input.trim().parse::<f32>().unwrap();
    input.clear();
    print!("Digite o segundo cateto: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let cateto_b = input.trim().parse::<f32>().unwrap();
    input.clear();
    let hipotenusa: f32 = (cateto_a.powi(2) + cateto_b.powi(2)).sqrt();
    println!("O valor da hipotenusa é: {}", hipotenusa);
}
