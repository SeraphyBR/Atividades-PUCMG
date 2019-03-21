// Definiçao de valores para variáveis  
int led10 = 10;
int led11 = 11;
int led12 = 12;
int led13 = 13;
int entrada = -1;
// put your setup code here, to run once:
void setup() {
    Serial.begin(9600);
    // configura os pinos como saídas DIGITAIS.
    pinMode(led10, OUTPUT);
    pinMode(led11, OUTPUT);
    pinMode(led12, OUTPUT);
    pinMode(led13, OUTPUT);
}

void loop() {
    // put your main code here, to run repeatedly:
    if(Serial.avaliable() > 0){
        entrada = Serial.parseInt();
        if (Serial.read() == '\n'){
            estado(entrada);
        }
    }
}

void estado(int e){
    switch(e){
        case 0:
            digitalWrite(led13, HIGH);
            digitalWrite(led12, LOW);
            digitalWrite(led11, LOW);
            digitalWrite(led10, LOW);
            break;
        case 1:
            digitalWrite(led13, HIGH);
            digitalWrite(led12, LOW);
            digitalWrite(led11, LOW);
            digitalWrite(led10, HIGH);
            break;
        case 2: 
            digitalWrite(led13, LOW);
            digitalWrite(led12, LOW);
            digitalWrite(led11, HIGH);
            digitalWrite(led10, LOW); 
            break;
        case 3: 
            digitalWrite(led13, LOW);
            digitalWrite(led12, LOW);
            digitalWrite(led11, HIGH);
            digitalWrite(led10, HIGH); 
            break;
        case 4: 
            digitalWrite(led13, LOW);
            digitalWrite(led12, HIGH);
            digitalWrite(led11, LOW);
            digitalWrite(led10, LOW); 
            break;
        case 5: 
            digitalWrite(led13, LOW);
            digitalWrite(led12, HIGH);
            digitalWrite(led11, LOW);
            digitalWrite(led10, HIGH); 
            break;
        default: 
            digitalWrite(led13, LOW);
            digitalWrite(led12, LOW);
            digitalWrite(led11, LOW);
            digitalWrite(led10, LOW); 
            break;
    }
}

