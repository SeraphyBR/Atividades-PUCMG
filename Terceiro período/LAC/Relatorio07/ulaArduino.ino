// Definiçao de valores para variáveis  
int led10 = 10, led11 = 11, led12 = 12, led13 = 13;

// put your setup code here, to run once:
void setup() {
    Serial.begin(9600);
    // configura os pinos como saídas DIGITAIS.
    pinMode(led10, OUTPUT);
    pinMode(led11, OUTPUT);
    pinMode(led12, OUTPUT);
    pinMode(led13, OUTPUT);
}

String hexToBin(char h)
{//Begin hexToBin
    String bin = ""; 
    switch(h){
        case '0':
            bin = "0000";
            break;
        case '1':
            bin = "0001";
            break;
        case '2':
            bin = "0010";
            break;
        case '3':
            bin = "0011";
            break;
        case '4':
            bin = "0100";
            break;
        case '5':
            bin = "0101";
            break;
        case '6':
            bin = "0110";
            break;
        case '7':
            bin = "0111";
            break;
        case '8':
            bin = "1000";
            break;
        case '9':
            bin = "1001";
            break;
        case 'A':
            bin = "1010";
            break;
        case 'B':
            bin = "1011";
            break;
        case 'C':
            bin = "1100";
            break;
        case 'D':
            bin = "1101";
            break;
        case 'E':
            bin = "1110";
            break;
        case 'F':
            bin = "1111";
            break;  
    } 
    return bin;
}//End hexToBin

int charToInt(char c){
    String s = String(c);
    int i = s.toInt();
    return i;
}

void mostraBin(int led, char a){
    if(a != '0') digitalWrite(led,HIGH);
    else digitalWrite(led,LOW);
} 

String Neg(String binary){
    String result = "";
    for(int c = 0; c < binary.length(); c++){
        if(binary.charAt(c) == '0') result += "1";
        else result += "0";
    }
    return result;
}

String Or(String a, String b){
    String result = "";
    if(a.length() == b.length()){
        for(int c = 0; c < a.length(); c++){
            if(a.charAt(c) != b.charAt(c)) result += "1";
            else result += a.charAt(c);
        }
    }
    return result;
}

String And(String a, String b){
    String result = "";
    if(a.length() == b.length()){
        for(int c = 0; c < a.length(); c++){
            if(a.charAt(c) == b.charAt(c)) result += a.charAt(c);
            else result += "0";
        }
    }
    return result;
}

String Xor(String a, String b){
    String result = "";
    if(a.length() == b.length()){
        for(int c = 0; c < a.length(); c++){
            if(a.charAt(c) != b.charAt(c)) result += "1";
            else result += "0";
        }
    }
    return result;
}

String instruction(String a, String b, char select)
{//Begin instruction
    String result = "";
    switch(select){
        case '0':
            result = "0000";
            break;
        case '1':
            result = "1111";
            break;
        case '2':
            result = Neg(a);
            break;
        case '3':
            result = Neg(b);
            break;
        case '4':
            result = Or(a, b);
            break;
        case '5':
            result = And(a, b);
            break;
        case '6':
            result = Xor(a, b);
            break;
        case '7':           
            result = Neg(And(a, b));
            break;
        case '8':
            result = Neg(Or(a, b));
            break;
        case '9':
            result = Neg(Xor(a, b));
            break;
        case 'A':
            result = Or(Neg(a), b);
            break;
        case 'B':
            result = Or(a, Neg(b));
            break;
        case 'C':
            result = And(Neg(a), b);
            break;
        case 'D':
            result = And(a, Neg(b));
            break;
        case 'E':
            result = Or(Neg(a), Neg(b));
            break;
        case 'F':
            result = And(Neg(a), Neg(b));
            break;
        default:
            Serial.println("Operacao invalida!");
            break;
    }
    return result;
}//End instruction

void loop()
{//Begin main loop
    // put your main code here, to run repeatedly:
    if(Serial.available() > 0){
        String entrada = Serial.readString();
        char a = entrada.charAt(0);
        char b = entrada.charAt(1);
        char select = entrada.charAt(2);
        if(Serial.read() == '\n'){
            String result = instruction(hexToBin(a), hexToBin(b), select);
            if(result.length() == 4){
                mostraBin(led10, result.charAt(3));
                mostraBin(led11, result.charAt(2));
                mostraBin(led12, result.charAt(1));
                mostraBin(led13, result.charAt(0));
                Serial.println(result);  
            }
            else {
                mostraBin(led10, 0);
                mostraBin(led11, 0);
                mostraBin(led12, 0);
                mostraBin(led13, 0);
                Serial.println(result); 
            }
        }
    }
}//End main loop    

