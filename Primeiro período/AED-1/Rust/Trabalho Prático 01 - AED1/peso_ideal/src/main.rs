use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    print!("Digite a sua altura em metros: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let altura = input.trim().parse::<f32>().unwrap();
    input.clear();
    println!("Insira o seu sexo.");
    print!("Digite 1 para masculino e 2 para feminino: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let peso = match input.trim().as_ref() {
        "1" => peso_ideal(altura, true),
        "2" => peso_ideal(altura, false),
        _ => 0.0,
    };
    println!("Seu peso ideal é: {:.2}kg", peso);
}

// sexo = true, masculino
// sexo = false, feminino
fn peso_ideal(altura: f32, sexo: bool) -> f32 {
    match sexo {
        true => (72.7 * altura) - 58.0,
        false => (61.1 * altura) - 44.7,
    }
}
