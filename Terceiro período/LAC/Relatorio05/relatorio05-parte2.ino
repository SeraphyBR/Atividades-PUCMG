// Definiçao de valores para variáveis  
int led10 = 10, led11 = 11, led12 = 12, led13 = 13;
int a = 0, b = 0, op = 0, result = 0, vaiUm = 0;
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

    if(Serial.available() > 0){
        a = Serial.parseInt();
        b = Serial.parseInt();
        op = Serial.parseInt();	
    }
    mostraBin(led13, a);
    mostraBin(led12, b);
    switch(op){
        case 0:
            result = a & b;
            break;
        case 1:
            result = a | b;
            break;
        case 2:
            result = ~a;
            break;
        case 3:
            result = a ^ b;
            vaiUm = a & b;
            break;
        default:
            break;
    }	
    mostraBin(led11, result);
    mostraBin(led10, vaiUm);
}        

void mostraBin(int led, int a){
    if(a != 0) digitalWrite(led,HIGH);
    else digitalWrite(led,LOW);
}

