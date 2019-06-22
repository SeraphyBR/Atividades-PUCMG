use std::io;
use std::io::Write;

fn main() {
    let (x, y): (f32,f32);
    println!("Qual método deseja executar?");
    println!("1 - maior\n2 - soma\n3 - par\n4 - perimetro_quadrado");
    println!("5 - area_quadrado\n6 - bissexto\n7 - peso_ideal");
    println!("8 - fatorial\n9 - potenciacao\n10 - maior_conjunto");
    let opcao = read("=> ");
    match opcao.trim() {
        "1" => {
            x = read("Digite um número real: ").trim().parse().unwrap();
            y = read("Digite outro número real: ").trim().parse().unwrap();
            println!("O maior é: {}", maior(x,y));
        },
        "2" => {
            x = read("Digite um número real: ").trim().parse().unwrap();
            y = read("Digite outro número real: ").trim().parse().unwrap();
            println!("O resultado da soma é: {}", soma(x,y));
        },
        "3" => {
            par(read("Digite um número inteiro: ").trim().parse::<i32>().unwrap());
        },
        "4" => {
            x = read("Digite o valor do lado do quadrado: ").trim().parse().unwrap();
            println!("O perímetro é: {}", perimetro_quadrado(x));
        },
        "5" => {
            x = read("Digite o valor do lado do quadrado: ").trim().parse().unwrap();
            println!("A área é: {}", area_quadrado(x));
        },
        "6" => {
            bissexto(read("Digite um ano: ").trim().parse().unwrap());
        },
        "7" => {
            let genero = read("Digite o seu gênero: [M/F]").trim().chars().next().unwrap();
            x = read("Digite a sua altura em metros: ").trim().parse::<f32>().unwrap();
            println!("O seu peso ideal é: {:.2}Kg", peso_ideal(genero,x));
        },
        "8" => {
            let num = read("Digite um numero inteiro: ").trim().parse::<i32>().unwrap();
            println!("O fatorial é: {}", fatorial(num));
        },
        "9" => {
            x = read("Digite a base: ").trim().parse::<f32>().unwrap();
            let y = read("Digite o expoente: ").trim().parse::<i32>().unwrap();
            println!("A potência é: {}", potenciacao(x,y));
        },
        _ => println!("Valor inválido!"),
    }
}//Fim main

fn maior(x: f32, y: f32) -> f32 {
    if x >= y {x}
    else {y}
}

fn soma(x: f32, y: f32) -> f32 {
    x + y
}

fn par(x: i32) {
    if x % 2 == 0 {println!("O número {} é par!", x)}
    else {println!("O número {} é impar!", x)}
}

fn perimetro_quadrado(lado: f32) -> f32 {
    lado * 4.0
}

fn area_quadrado(lado: f32) -> f32 {
    lado * lado
}

fn bissexto(ano: i32) {
    if ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) {
        println!("O ano {} é bissexto.", ano)
    }
    else {println!("O ano {} não é bissexto.", ano)}
}

fn peso_ideal(gender: char, altura: f32) -> f32 {
    match gender {
        'm'|'M' => 72.7 * altura - 58.0,
        'f'|'F' => 61.1 * altura - 44.7,
        _ => 0.0,
    }
}

fn fatorial(num: i32) -> i32 {
    let mut result = 1;
    for i in (1..num).rev() {
        result *= i;
    };
    result
}

fn potenciacao(base: f32, expoente: i32) -> f32 {
    let mut result = 1.0;
    for _i in 0..expoente {
        result *= base;
    };
    result
}

fn read(msg:&str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Erro ao tentar ler do teclado!");
    input
}
