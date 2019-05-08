# i - $s0 
# soma - $s1
.text
.globl main
main:
	# Colocar endereco base da memoria em t0
	addi $t0,$t0,0x1001
	sll  $t0,$t0,16
	
	addi $s0,$zero,0 # comeca i = 0
	addi $t3,$zero,100 # Colocando t3 = 100
	
do: # Preenche o vetor de 100 
	# t1 = 2 * i + 1
	sll $t1,$s0,1
	addi $t1,$t1,1
	
	# vetor[i] = t1
	sll $t2,$s0,2
	add $t2,$t2,$t0
	sw $t1,0($t2)

	addi $s0,$s0,1 # i++
	
	# i != t3
	bne $s0,$t3,do
	j endWhile
	
endWhile:
	addi $s0,$zero,0 # Define i = 0
	addi $s1,$zero,0 # Define soma = 0

do2:
	# soma += vetor[i]
	sll $t2,$s0,2
	add $t2,$t2,$t0
	lw $t4, 0($t2)
	add $s1,$s1,$t4
	
	addi $s0,$s0,1 # i++
	
	# i != t3
	bne $s0,$t3,do2
	j endWhile2
	
endWhile2:
	sw $s1, 0($t2)