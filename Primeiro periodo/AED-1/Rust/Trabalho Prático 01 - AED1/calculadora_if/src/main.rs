use std::io;
use std::io::Write;

fn main(){
    let mut input = String::new();
    println!("Calculadora:\nQue operação deseja realizar?");
    print!("Digite:\n1-Somar\n2-Subtrair\n3-Multiplicar\n4-Dividir\n=> ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    match input.trim().as_ref() {
        "1" => soma(),
        "2" => sub(),
        "3" => mult(),
        "4" => div(),
        _ => println!("Isso não é uma opção!"),
    }
}

fn soma(){
    println!(" A + B ");
    print!("Insira o valor de A: ");
    io::stdout().flush().unwrap();
    let mut a = String::new();
    io::stdin().read_line(&mut a).unwrap();
    print!("Insira o valor de B: ");
    io::stdout().flush().unwrap();
    let mut b = String::new();
    io::stdin().read_line(&mut b).unwrap();
    let a = a.trim().parse::<f32>().unwrap();
    let b = b.trim().parse::<f32>().unwrap();
    let result = a + b;
    println!("{} + {} = {}", a,b,result);
}

fn sub(){
    println!(" A - B ");
    print!("Insira o valor de A: ");
    io::stdout().flush().unwrap();
    let mut a = String::new();
    io::stdin().read_line(&mut a).unwrap();
    print!("Insira o valor de B: ");
    io::stdout().flush().unwrap();
    let mut b = String::new();
    io::stdin().read_line(&mut b).unwrap();
    let a = a.trim().parse::<f32>().unwrap();
    let b = b.trim().parse::<f32>().unwrap();
    let result = a - b;
    println!("{} - {} = {}", a,b,result);
}

fn mult(){
    println!(" A * B ");
    print!("Insira o valor de A: ");
    io::stdout().flush().unwrap();
    let mut a = String::new();
    io::stdin().read_line(&mut a).unwrap();
    print!("Insira o valor de B: ");
    io::stdout().flush().unwrap();
    let mut b = String::new();
    io::stdin().read_line(&mut b).unwrap();
    let a = a.trim().parse::<f32>().unwrap();
    let b = b.trim().parse::<f32>().unwrap();
    let result = a * b;
    println!("{} * {} = {}", a,b,result);
}

fn div(){
    println!(" A / B ");
    print!("Insira o valor de A: ");
    io::stdout().flush().unwrap();
    let mut a = String::new();
    io::stdin().read_line(&mut a).unwrap();
    print!("Insira o valor de B: ");
    io::stdout().flush().unwrap();
    let mut b = String::new();
    io::stdin().read_line(&mut b).unwrap();
    let a = a.trim().parse::<f32>().unwrap();
    let b = b.trim().parse::<f32>().unwrap();
    let result = a / b;
    println!("{} / {} = {}", a,b,result);
}
