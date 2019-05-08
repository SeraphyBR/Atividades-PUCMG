
# i - $s0 

.text
.globl main

main:

	# Colocar endereco base da memoria em t0
	addi $t0,$t0,0x1001
	sll  $t0,$t0,16
	
	# Comeca i = 0
	addi $s0,$zero,0
	
	# Colocando t3 = 100
	addi $t3,$zero,100
	
do:
	# t1 = 2 * i + 1
	sll $t1,$s0,1
	addi $t1,$t1,1
	
	# vetor[i] = t1
	sll $t2,$s0,2
	add $t2,$t2,$t0
	sw $t1,0($t2)
	
	# i++
	addi $s0,$s0,1
	
	# i != t3
	bne $s0,$t3,do
	j exit
	
exit:

	