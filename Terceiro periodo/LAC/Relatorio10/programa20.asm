# i - $s0 
# j - $s1
# soma - $s2
.text
.globl main
main:
	# Colocar endereco base da memoria em t0
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16
	addi $s0,$zero,0 # comeca i = 0
	addi $t3,$zero,99 # Colocando t3 = 99
	
do: # Preenche o vetor com impares até 100
	# t1 = 2 * i + 1
	sll $t1,$s0,1
	addi $t1,$t1,1
	
	# vetor[i] = t1
	sll $t2,$s0,2
	add $t2,$t2,$t0
	sw $t1,0($t2)

	addi $s0,$s0,1 # i++

	slt $s1,$t1,$t3 # j = t1 < 99
	bne $s1,$zero,do # while(j)
	j endWhile
	
endWhile:

	addi $s2,$zero,0 # Define soma = 0
	addi $s0,$s0,-1 # i-- para remover ultimo i++
do2:
	# soma += vetor[i]
	sll $t4,$s0,2
	add $t4,$t4,$t0
	lw $t5, 0($t4)
	add $s2,$s2,$t5
	
	addi $s0,$s0,-1 # i--
	# while(i >= 0)
	slt $t6,$s0,$zero
	beq $t6,$zero,do2
	j endWhile2
	
endWhile2:
	sw $s2,0($t2) # Escreve a soma na ultima posicao 
