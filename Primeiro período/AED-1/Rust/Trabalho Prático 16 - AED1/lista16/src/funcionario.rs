use chrono::prelude::*;
use brids::Cpf;
use std::fmt;

#[derive(Debug, Clone)]
pub struct Funcionario {
    nome: String,
    cpf: Cpf,
    nascimento: Date<Local>,
    admissao: Date<Local>,
    salario: f32,
}

#[allow(dead_code)]
impl Funcionario {
    pub fn new(nome: String, cpf: Cpf, nascimento: Date<Local>, salario: f32) -> Funcionario {
        Funcionario {
            nome,
            cpf,
            nascimento,
            admissao: Local::today(),
            salario,
        }
    }

    pub fn set_salario(&mut self, salario: f32) {
        self.salario = salario;
    }

    pub fn get_salario(&self) -> f32 {
        self.salario
    }

    pub fn get_nome(&self) -> String {
        self.nome.clone()
    }

    pub fn get_cpf(&self) -> Cpf {
        self.cpf
    }

    pub fn get_nascimento(&self) -> Date<Local> {
        self.nascimento
    }
}

impl fmt::Display for Funcionario {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        writeln!(f, "Funcionario: ")?;
        writeln!(f, "\tNome: {}", self.get_nome().trim())?;
        writeln!(f, "\tCPF: {}", self.get_cpf())?;
        writeln!(
            f,
            "\tData de nascimento: {}",
            self.nascimento.format("%d-%m-%Y").to_string()
        )?;
        writeln!(
            f,
            "\tData de admissao: {}",
            self.admissao.format("%d-%m-%Y").to_string()
        )?;
        writeln!(f, "\tSalario: R${:.2}", self.get_salario())
    }
}
