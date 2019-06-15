use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa irá dizer se um ano é bissexto ou não.");
    loop {
        input.clear();
        print!("Digite um ano: ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();
        let ano = input.trim().parse::<i32>().unwrap();
        input.clear();
        if (ano % 4 == 0) && ((ano % 100 != 0) || (ano%400 == 0)) {
            println!("O ano {} é bissexto.", ano);
        }
        else {
            println!("O ano {} não é bissexto.", ano)
        }
        println!("\nDeseja digitar outro ano?");
        println!("Digite: 's' => sim e 'n' => não.");
        print!(">: ");
        io::stdout().flush().unwrap();
        io::stdin().read_line(&mut input).unwrap();
        if input.trim() != "s" {
            break;
        }

    };
}
