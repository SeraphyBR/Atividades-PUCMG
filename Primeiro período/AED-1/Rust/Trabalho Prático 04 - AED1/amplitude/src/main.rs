use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    let mut maior = 0;
    let mut menor = 10000;
    let mut num;
    println!("Esse programa irá ler um conjunto de valores inteiros e positivos,");
    println!("e irá imprimir a sua amplitude.");
    loop {
        loop {
            print!("Digite um número: ");
            io::stdout().flush().unwrap();
            io::stdin().read_line(&mut input).unwrap();
            num = input.trim().parse::<i32>().expect("Isso não é um numero inteiro!");
            input.clear();
            if num < 0 {println!("Valor inválido!\nDigite novamente.\n")}
            if num >= 0 {break}

        }//Fim loop
        if num >= maior && num != 0 {maior = num}
        if num <= menor && num != 0 {menor = num}
        if num == 0 {break}
    }//Fim loop
    if maior > 0 {
        let amplitude = maior - menor;
        println!("O maior valor lido é: {}", maior);
        println!("O menor valor lido é: {}", menor);
        println!("A amplitude é: {}", amplitude);
    }
    else {println!("Nenhum valor informado!")}

    print!("Deseja repetir o programa? [s/n]: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let op = input.trim().chars().next().unwrap();
    input.clear();
    if op == 's' {main()}
}//Fim main
