use human_panic::setup_panic;

mod lib;
use lib::Grafo;

fn main() {
    setup_panic!(); // Nice error message
    let mut g = Grafo::comum(4);
    println!("Hello, world!");
}
