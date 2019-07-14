use chrono::prelude::*;
use std::fmt;

#[derive(Debug, Clone)]
pub struct Funcionario {
    nome: String,
    cpf: String,
    nascimento: Date<Local>,
    admissao: Date<Local>,
    salario: f32,
}

#[allow(dead_code)]
impl Funcionario {
    pub fn new(nome: String, cpf: String, nascimento: Date<Local>, salario: f32) -> Funcionario {
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

    pub fn cpf_valido(cpf: String) -> bool {
        cpf.retain(|c| c != '.' && c != '-');
        if cpf.len() == 11 {
            let ver1 = Funcionario::cal_digito_ver1(cpf);
            let chars = cpf.chars();
            if chars.nth(9).unwrap() as u8 == ver1 {
                let ver2 = Funcionario::cal_digito_ver2(cpf);
                if chars.nth(10).unwrap() as u8 == ver2 {
                    true
                } else {
                    false
                }
            } else {
                false
            }
        } else {
            false
        }
    }

    fn cal_digito_ver1(cpf: String) -> u8 {
        let mut sum = 0;
        let chars = cpf.chars();
        for i in (2..=10).rev() {
            sum += chars.next().unwrap() as u8 * i
        }
        if (sum % 11) < 2 {
            0
        } else {
            11 - (sum % 11)
        }
    }

    fn cal_digito_ver2(cpf: String) -> u8 {
        let mut sum = 0;
        let chars = cpf.chars();
        for i in (2..=11).rev() {
            sum += chars.next().unwrap() as u8 * i
        }
        if (sum % 11) < 2 {
            0
        } else {
            11 - (sum % 11)
        }
    }

    pub fn get_cpf(&self) -> String {
        self.cpf.clone()
    }

    pub fn get_nascimento(&self) -> Date<Local> {
        self.nascimento
    }
}

impl fmt::Display for Funcionario {
    fn fmt(&self, f: &mut fmt::Formatter) -> fmt::Result {
        writeln!(f, "Funcionario: ")?;
        writeln!(f, "\tNome: {}", self.get_nome())?;
        writeln!(f, "\tCPF: {}", self.get_cpf())?;
        writeln!(
            f,
            "\tData de nascimento: {}",
            self.nascimento.format("%Y-%m-%d %H:%M:%S").to_string()
        )?;
        writeln!(
            f,
            "\tData de admissao: {}",
            self.admissao.format("%Y-%m-%d %H:%M:%S").to_string()
        )?;
        writeln!(f, "\tSalario: {}", self.get_salario())
    }
}
