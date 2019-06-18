use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    println!("Esse programa calcula os termos da seguinte sequencia:");
    println!("1/100, 97/2, 3/94, 91/4, 5/88, ...");
    read("Digite a quantidade de termos: ", &mut input);
    let termos = input.trim().parse::<i32>().unwrap();
    let mut h;
    let mut a = 1;
    let mut b = 100;
    for step in 0..termos {
        if step % 2 == 0 {
            h = a as f32 / b as f32;
        }
        else {
            h = b as f32 / a as f32;
        }
        println!("{}", h);
        a += 1;
        b -= 3;
    }

}

fn read(msg: &str, input: &mut String){
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin().read_line(input).unwrap();
}
