use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();

    print!("Digite a coordenada X do ponto A: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Não foi possível ler o valor!");
    let xa = input.trim().parse::<f32>().expect("Não foi converter para ponto flutuante!");
    input.clear();
    
    print!("Digite a coordenada Y do ponto A: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Não foi possível ler o valor!");
    let ya = input.trim().parse::<f32>().expect("Não foi converter para ponto flutuante!");
    input.clear();

    print!("Digite a coordenada X do ponto B: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Não foi possível ler o valor!");
    let xb = input.trim().parse::<f32>().expect("Não foi converter para ponto flutuante!");
    input.clear();

    print!("Digite a coordenada Y do ponto B: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Não foi possível ler o valor!");
    let yb = input.trim().parse::<f32>().expect("Não foi converter para ponto flutuante!");
    input.clear();

    let result: f32 = ((xb - xa).powf(2.0) + (yb - ya).powf(2.0)).sqrt();
    println!("A distancia entre os pontos A e B é {:.3}", result);
}
