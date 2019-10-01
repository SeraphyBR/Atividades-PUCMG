use std::io;
use std::io::Write;
use std::cmp::Ordering;

fn main() {
    let mut input = String::new();
    println!("Uma equação de segundo grau obedece o seguinte formato: Ax²+Bx+C");

    print!("Digite o valor de A: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let a = input.trim().parse::<f32>().unwrap();
    input.clear();

    print!("Digite o valor de B: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let b = input.trim().parse::<f32>().unwrap();
    input.clear();

    print!("Digite o valor de C: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let c = input.trim().parse::<f32>().unwrap();
    input.clear();

    let delta = b.powi(2) - 4.0 * a * c;
    let x1 = (- b + delta.sqrt()) / (2.0 * a);
    let x2 = (- b - delta.sqrt()) / (2.0 * a);

    match delta.partial_cmp(&0.0).unwrap() {
        Ordering::Less => println!("Não há solução para essa equação!"),
        Ordering::Equal => println!("A raiz é: {}", x1),
        Ordering::Greater => println!("As raízes são: {} e {}", x1, x2),
    };

}
