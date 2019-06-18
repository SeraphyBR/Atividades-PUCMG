use std::io;
use std::io::Write;

fn main() {
    let mut input = String::new();
    let mut genero;
    let mut homens = 0;
    let mut mulheres = 0;
    let mut idade: i16;
    let mut velho: i16 = 0;
    let mut jovem: i16 = 100;
    let mut adulto: i16 = 0;
    let mut cont = 1;

    println!("Esse programa irá identificar o perfil de uma turma.");
    println!("Digite [ e ] como gênero para finalizar a leitura.\n");
    loop {
        loop {
            print!("Aluno {}: Qual o seu gênero? [m / f]: ", cont);
            io::stdout().flush().unwrap();
            io::stdin().read_line(&mut input).unwrap();
            genero = input.trim().chars().next().unwrap();
            input.clear();
            match genero {
                'm'|'f'|'e' => break,
                _ => continue,
            }
        }//Fim loop

        if genero == 'm' {homens += 1};
        if genero == 'f' {mulheres += 1};

        if genero != 'e' {
            loop {
                print!("Qual a sua idade? ");
                io::stdout().flush().unwrap();
                io::stdin().read_line(&mut input).unwrap();
                idade = input.trim().parse::<i16>().unwrap();
                input.clear();
                if idade > 100 || idade < 0 {
                    println!("Valor inválido!\n");
                }
                else {break};
            }//Fim loop

            if idade >= 18 {adulto += 1};
            if idade >= velho {velho = idade};
            if idade <= jovem {jovem = idade};

            cont += 1;
        }
        else {
            println!("Encerrando leitura...");
            break;
        };
    }//Fim loop

    if cont > 1 {
        println!("O percentual de homens na turma é: {}%.", (homens as f32/cont as f32) * 100.0);
        println!("O percentual de mulheres na turma é: {}%.", (mulheres as f32/cont as f32) * 100.0);
        println!("O percentual de alunos maiores de idade é: {}%.", (adulto as f32/cont as f32) * 100.0);
        println!("A idade da pessoa mais velha é: {} anos.", velho);
        println!("A idade da pessoa mais nova é: {} anos.", jovem);
    }
    else {println!("Não há informação para mostrar!")};
}//Fim main
