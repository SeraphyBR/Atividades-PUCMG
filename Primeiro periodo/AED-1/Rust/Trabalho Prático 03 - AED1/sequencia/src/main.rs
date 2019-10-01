use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    let mut num;
    let mut valores = 0.0;
    let mut maior = 0.0;
    let mut count = 0;
    println!("Esse programa lê os números digitados, calcula a média");
    println!("desses números e imprime o maior valor que foi lido.");
    println!("Para parar o processo de leitura, digite 0.");
    println!("Obs: O programa não irá aceitar valores negativos.\n");

    loop {
        print!("Digite um número natural: ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();
        num = input.trim().parse::<f32>().unwrap();
        input.clear();
        if num < 0.0 {
            println!("Número inválido!");
        }
        else if num == 0.0 {
            println!("Encerrando leitura...");
            break;
        }
        else {
            valores += num;
            count += 1;
            if num >= maior {maior = num};
        }
    }//Fim loop

    if count > 0 {
        let media = valores / count as f32;
        println!("A média dos números lidos é: {}", media);
        println!("O maior valor lido é: {}", maior);
    }
    else {
        println!("Não há nada para ser calculado!");
    }

}//Fim main
