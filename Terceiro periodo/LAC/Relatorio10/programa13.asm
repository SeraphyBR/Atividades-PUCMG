.text
.globl main

main:
	# Colocar endereco base da memoria em t0
	addi $t0,$t0,0x1001
	sll  $t0,$t0,16
	
	# Obter valor da memoria
	lw   $s0,0($t0)
	
	# Verificar bit de sinal
	srl  $t1,$s0,31
	andi $t1,$t1,0x0001
	
	# Se diferente de 0, faz o modulo 
	bne  $t1,$zero,nega
	j pos
	
nega: 
	not $s0,$s0
	add $s0,$s0,1
	
pos:
	sw $s0,0($t0) # Salvar o resultado na memoria
	
.data
A: .word -42
	  