.text
.globl main

main:
	# Colocar endereco base da memoria em t0
	addi $t0,$t0,0x1001
	sll  $t0,$t0,16
	
	# Obter valor TEMP da memoria
	lw   $s0,0($t0)
	
	# Verifica se eh >= 30
	addi $t1,$zero,30
	slt $t1,$s0,$t1 # 1 se for < 30, 0 se for >= 30
	
	# Se igual a 0, faz o modulo 
	beq  $t1,$zero,teste2
	j zero
	
teste2:
	# Verifica se eh <=50 
	addi $t2,$zero,50
	slt $t2,$t2,$s0 # 1 se for 50 < TEMP, 0 se for 50 >= TEMP
	
	# Se igual a 0, FLAG = 1
	beq $t2,$zero,um
	j zero
	
um:
	# Colocar um em FLAG
	addi $t3,$zero,1
	sw $t3,4($t0)
	j fim
	
zero: 
	# Colocar zero em FLAG
	sw $zero,4($t0)
	j fim
	
fim:
	
.data
TEMP: .word 35
FLAG: .word 0
	  
