use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa analisa o tipo de um triangulo.");

    print!("Digite o primeiro lado do triângulo: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let lado_a: f32 = input.trim().parse().unwrap();
    input.clear();

    print!("Digite o segundo lado do triângulo: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let lado_b: f32 = input.trim().parse().unwrap();
    input.clear();

    print!("Digite o terceiro lado do triângulo: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let lado_c: f32 = input.trim().parse().unwrap();
    input.clear();

    verifica_tipo_triangulo(lado_a, lado_b, lado_c);

}

fn verifica_tipo_triangulo(lado_a: f32, lado_b: f32, lado_c: f32){
    if valida_triangulo(lado_a, lado_b, lado_c) {
        if (lado_a != lado_b) && (lado_a != lado_c) && (lado_b != lado_c) {
            println!("O triângulo é escaleno.");
        }
        else if (lado_a == lado_b) && (lado_a == lado_c) && (lado_b == lado_c){
            println!("O triângulo é equilátero.");
        }
        else {
            println!("O triângulo é isoscéles.");
        }
    }
    else {
        println!("Os valores não condizem com um triangulo válido!");
    }
}

/// Para construir um triangulo é necessário que a medidade qualquer
/// um dos lados seja menor que a soma das medidas dos outros dois e
/// maior que o valor absoluto da diferença entre essas medidas.
/// 1: |b - c| < a < (b + c)
/// 2: |a - c| < b < (a + c)
/// 3: |a - b| < c < (a + b)
fn valida_triangulo(lado_a: f32, lado_b: f32, lado_c: f32) -> bool {
    if lado_a < (lado_b+lado_c) && (lado_b-lado_c).abs() < lado_a {
        if lado_b < (lado_a+lado_c) && (lado_a-lado_c).abs() < lado_b {
            lado_c < (lado_a+lado_b) && (lado_a-lado_b).abs() < lado_c
        }
        else {
            false
        }
    }
    else {
        false
    }
}
