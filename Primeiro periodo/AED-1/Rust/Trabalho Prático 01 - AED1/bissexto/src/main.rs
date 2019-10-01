use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    print!("Digite um ano: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).unwrap();
    let ano: i32 = input.trim().parse::<i32>().unwrap();
    if ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) {
        println!("O ano {} é bissexto.", ano);
    }
    else{
        println!("O ano {} não é bissexto.", ano);
    }
}
