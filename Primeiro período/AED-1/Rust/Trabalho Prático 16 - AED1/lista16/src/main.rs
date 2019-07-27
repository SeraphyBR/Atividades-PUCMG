use std::io;
use std::io::Write;

mod funcionario;
use funcionario::Funcionario;

use brids::Cpf;
use chrono::prelude::*;
use human_panic::setup_panic;

fn main() {
    setup_panic!(); //Nice error mensage
    println!("Para começar a usar o sistema,");
    let qnt = loop {
        match read("Digite a quantidade máxima de funcionarios: ").trim().parse::<usize>(){
            Ok(qnt) => {
                if qnt == 0 {
                    println!("Quantidade inválida!");
                    continue;
                } else {
                    break qnt;
                }
            }
            Err(_) => {
                println!("Quantidade inválida!");
                continue;
            }
        }
    };

    let mut registro: Vec<Funcionario> = Vec::with_capacity(qnt);
    loop {
        match menu() {
            '0' => break,
            '1' => add_funcionario(&mut registro),
            '2' => match busca_func_nome(&registro, read("Digite o nome: ")) {
                Ok(f) => println!("{}", f),
                Err(e) => println!("{}", e),
            },
            '3' => {
                match read("Digite o CPF: ").trim().parse::<Cpf>() {
                    Ok(cpf) => {
                        match busca_func_cpf(&registro, cpf) {
                            Ok(f) => println!("{}", f),
                            Err(e) => println!("{}", e),
                        }
                    },
                    Err(_) => {
                        println!("CPF inválido!");
                    }
                }
            },
            '4' => lista_func_sal(&registro),
            '5' => lista_func_data(&registro),
            '6' => lista_func_aniv(&registro),
            '7' => ler_arq(&mut registro),
            '8' => salvar_arq(&registro),
            _ => println!("Ação Inexistente!"),
        }
    }
} //Fim main()

fn menu() -> char {
    println!("\n\tSistema de gestão de funcionários");
    println!("Escolha uma ação: ");
    println!("0 - Sair");
    println!("1 - Adicionar um novo Funcionario");
    println!("2 - Buscar funcionario por Nome");
    println!("3 - Buscar funcionario pelo CPF");
    println!("4 - Listar funcionários com salario acima de X");
    println!("5 - Listar funcionarios admitidos numa data");
    println!("6 - Listar funcionarios aniversariantes do mês");
    println!("7 - Ler registro do arquivo");
    println!("8 - Salvar registro em arquivo");
    loop {
        match read("=> ").trim().chars().next() {
            Some(op) => break op,
            None => continue,
        }
    }
} //Fim menu()

fn add_funcionario(registro: &mut Vec<Funcionario>) {
    if registro.len() < registro.capacity() {
        registro.push(le_funcionario());
        registro.sort_by(|f1, f2| f1.get_cpf().cmp(&f2.get_cpf()));
        println!("Funcionario adicionado com sucesso.");
    } else {
        println!("Número máximo de funcionarios atingido!");
    }
}

fn le_funcionario() -> Funcionario {
    let nome = read("\nDigite o nome do funcionario: ");
    let cpf = loop {
        let input = read("Digite o CPF: ");
        match input.trim().parse::<Cpf>() {
            Ok(cpf) => break cpf,
            Err(_) => {
                println!("CPF inválido!");
                continue;
            },
        }
    };
    let nascimento: Date<Local> = loop {
        println!("Data de nascimento: ");
        let data = le_data();
        if Local::today().year() - data.year() >= 16 {
            break data;
        } else {
            println!("Não é permitido menores de 16 anos!");
            continue;
        }
    };
    let salario = loop {
        match read("Digite o salario atual: ").trim().parse::<f32>() {
            Ok(salario) => break salario,
            Err(_) => {
                println!("Valor inválido!\nTente novamente.");
                continue;
            }
        }
    };
    Funcionario::new(nome, cpf, nascimento, salario)
} //Fim le_funcionario()

fn le_data() -> Date<Local> {
    let dia = loop {
        match read("\tDia: ").trim().parse::<u32>() {
            Ok(dia) => {
                if dia > 31 {
                    println!("\tDia inválido!\nTente novamente");
                    continue;
                } else {
                    break dia;
                }
            }
            Err(_) => {
                println!("\tDia inválido!\nTente novamente.");
                continue;
            }
        }
    };
    let mes = loop {
        match read("\tMês: ").trim().parse::<u32>() {
            Ok(mes) => {
                if mes > 12 {
                    println!("\tMês inválido!\nTente novamente.");
                    continue;
                } else {
                    break mes;
                }
            }
            Err(_) => {
                println!("\tMês inválido!\nTente novamente.");
                continue;
            }
        }
    };
    let ano = loop {
        match read("\tAno: ").trim().parse::<i32>() {
            Ok(ano) => break ano,
            Err(_) => {
                println!("\tAno inválido!\nTente novamente.");
                continue;
            }
        }
    };
    Local.ymd(ano, mes, dia)
} //Fim le_data()

fn busca_func_nome(registro: &Vec<Funcionario>, nome: String) -> Result<Funcionario, &str> {
    for f in registro {
        if f.get_nome() == nome {
            return Ok(f.clone());
        }
    }
    Err("Funcionario não encontrado!")
}

fn busca_func_cpf(registro: &Vec<Funcionario>, cpf: Cpf) -> Result<Funcionario, &str> {
    match registro.binary_search_by(|func| func.get_cpf().cmp(&cpf)) {
        Ok(index) => Ok(registro[index].clone()),
        Err(_) => Err("Funcionario não encontrado!"),
    }
}

fn lista_func_aniv(registro: &Vec<Funcionario>) {

}

fn lista_func_data(registro: &Vec<Funcionario>) {

}

fn lista_func_sal(registro: &Vec<Funcionario>) {

}

fn ler_arq(registro: &mut Vec<Funcionario>) {

}

fn salvar_arq(registro: &Vec<Funcionario>) {

}

fn read(msg: &str) -> String {
    let mut input = String::new();
    print!("{}", msg);
    io::stdout().flush().unwrap();
    io::stdin()
        .read_line(&mut input)
        .expect("Erro ao ler do teclado!");
    input
} //Fim read()
