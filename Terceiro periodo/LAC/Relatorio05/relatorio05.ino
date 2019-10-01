// Definiçao de valores para variáveis  
int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;

// put your setup code here, to run once:
void setup() {
  // configura os pinos como saídas DIGITAIS.
  pinMode(led10, OUTPUT);
  pinMode(led11, OUTPUT);
  pinMode(led12, OUTPUT);
  pinMode(led13, OUTPUT);

  digitalWrite(led10, LOW);
  digitalWrite(led11, LOW);
  digitalWrite(led12, LOW);
  digitalWrite(led13, LOW);
}

 void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(led13, HIGH);
  piscaAzul(3);
  digitalWrite(led13, LOW);
  digitalWrite(led11,HIGH);
  piscaAzul(4);
  digitalWrite(led11, LOW);
  digitalWrite(led12, HIGH);
  piscaAzul(2);
  digitalWrite(led12, LOW);
  delay(100);
}

void piscaAzul(int ciclos){
  for(int ciclo = 0; ciclo < ciclos; ciclo++){
    digitalWrite(led10,HIGH);
    delay(1000);
    digitalWrite(led10,LOW);
    delay(1000);        
  }
}

