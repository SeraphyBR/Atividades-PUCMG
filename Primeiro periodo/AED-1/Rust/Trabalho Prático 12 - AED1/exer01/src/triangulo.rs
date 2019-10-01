#[derive(Debug, Copy, Clone)]
pub struct Triangulo {
    lado_a: f32,
    lado_b: f32,
    lado_c: f32,
}

#[allow(dead_code)]
impl Triangulo {
    pub fn new(lado_a: f32, lado_b: f32, lado_c: f32) -> Triangulo {
        let mut triangulo = Triangulo::new_empty();
        triangulo.set_lados(lado_a, lado_b, lado_c);
        triangulo
    }

    pub fn new_empty() -> Triangulo {
        Triangulo {
            lado_a: 0.0,
            lado_b: 0.0,
            lado_c: 0.0,
        }
    }

    pub fn get_lados(&self) -> (f32, f32, f32) {
        (self.lado_a, self.lado_b, self.lado_c)
    }

    pub fn set_lados(&mut self, a: f32, b: f32, c: f32) {
        if a < 0.0 {
            self.lado_a = 0.0
        } else {
            self.lado_a = a
        }
        if b < 0.0 {
            self.lado_b = 0.0
        } else {
            self.lado_b = b
        }
        if c < 0.0 {
            self.lado_c = 0.0
        } else {
            self.lado_c = c
        }
    }

    pub fn perimetro(&self) -> f32 {
        self.lado_a + self.lado_b + self.lado_c
    }

    pub fn eh_valido(a: f32, b: f32, c: f32) -> bool {
        let caso_1 = (b - c).abs() < a && a < (b + c);
        let caso_2 = (a - c).abs() < b && b < (a + c);
        let caso_3 = (a - b).abs() < c && c < (a + b);
        caso_1 && caso_2 && caso_3
    }

    pub fn eh_igual(&self, outro: &Triangulo) -> bool {
        let caso_1 = self.lado_a == outro.lado_a;
        let caso_2 = self.lado_b == outro.lado_b;
        let caso_3 = self.lado_c == outro.lado_c;
        caso_1 && caso_2 && caso_3
    }

    pub fn tipo(&self) -> TrianguloType {
        if (self.lado_a == self.lado_b) && (self.lado_b == self.lado_c) {
            TrianguloType::Equilatero
        }
        else if (self.lado_a == self.lado_b)||(self.lado_a == self.lado_c)||(self.lado_b == self.lado_c) {
            TrianguloType::Isoscele
        } else {
            TrianguloType::Escaleno
        }
    }
} //Fim impl Triangulo

#[derive(Debug)]
pub enum TrianguloType {
    Equilatero,
    Isoscele,
    Escaleno,
} //Fim TrianguloType
