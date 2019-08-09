use brids::Cpf;
use chrono::prelude::*;
use serde::{Deserialize, Serialize};
use std::fmt;

#[derive(Debug, Clone, Serialize, Deserialize)]
pub struct Funcionario {
    nome: String,
    cpf: Cpf,
    nascimento: NaiveDate,
    admissao: NaiveDate,
    salario: f32,
}

#[allow(dead_code)]
impl Funcionario {
    pub fn new(nome: String, cpf: Cpf, nascimento: NaiveDate, salario: f32) -> Funcionario {
        Funcionario {
            nome,
            cpf,
            nascimento,
            admissao: Utc::today().naive_utc(),
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

    pub fn get_nascimento(&self) -> NaiveDate {
        self.nascimento
    }

    pub fn get_admissao(&self) -> NaiveDate {
        self.admissao
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
