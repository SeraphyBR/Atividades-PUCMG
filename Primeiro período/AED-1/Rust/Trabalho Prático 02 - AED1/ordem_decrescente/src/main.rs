use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa mostra os numeros que");
    println!("estão entre um intervalo, em ordem decrescente.");
    read("Digite o primeiro valor: ", &mut input);
    let inicio = input.trim().parse::<i32>().unwrap();
    input.clear();
    read("Digite o ultimo valor: ", &mut input);
    let fim = input.trim().parse::<i32>().unwrap();
    for n in (inicio..=fim).rev() {
        println!("{}", n);
    };
}

fn read(msg: &str, input: &mut String){
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(input).unwrap();
}
