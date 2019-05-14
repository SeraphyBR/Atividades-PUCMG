;************** AULA 01 - PROVA *************
LIST   P=PIC16F628A
RADIX DEC 
#INCLUDE <P16F628A.INC>
 __CONFIG H'3F10'

 CBLOCK 0x20 ;ENDEREÇO INICIAL DA MEMÓRIA DE USUÁRIO
 CONTADOR1
 CONTADOR2
 CONTADOR3
 CONTADOR4
 ENDC   ;FIM DO BLOCO DE MEMÓRIA  
 
 ORG 0x00  ;ENDEREÇO INICIAL DE PROCESSAMENTO
 GOTO INICIO
  
INICIO
 CLRF PORTA  ;LIMPA O PORTA
 CLRF PORTB  ;LIMPA O PORTB
 BSF STATUS, RP0
 CLRF TRISB
 BCF STATUS, RP0

REPETE        ; while(true){
 BSF PORTB, 1 ;     RB1 = 1; 
 CALL ATRASO  ;     atraso();
 BCF PORTB, 1 ;     RB1 = 0;
 CALL ATRASO  ;     atraso();
 GOTO REPETE  ; }


ATRASO            ; atraso(){
 MOVLW 162        ;     for(contador1 = 162; contador1 != 0; contador1--){
 MOVWF CONTADOR1  ;         for(contador2 = 162; contador2 != 0; contador2--){
ATRASO1           ;             for(contador3 = 159; contador3 != 0; contador3--);
 MOVLW 162        ;         }
 MOVWF CONTADOR2  ;     }
ATRASO2           ;     offset();
 MOVLW 159        ;
 MOVWF CONTADOR3  ;
ATRASO3           ;
 DECFSZ CONTADOR3 ;
 GOTO ATRASO3     ;
 DECFSZ CONTADOR2 ;
 GOTO ATRASO2     ;
 DECFSZ CONTADOR1 ;
 GOTO ATRASO1     ;
 CALL OFFSET      ;
 RETURN           ; }
 
OFFSET            ; offset(){
 MOVLW 5          ;     for(contador4 = 5; contador4 != 0; contador4--);
 MOVWF CONTADOR4  ;
ATRASO4           ;
 DECFSZ CONTADOR4 ;
 GOTO ATRASO4     ;
 RETURN           ; }
    
END

