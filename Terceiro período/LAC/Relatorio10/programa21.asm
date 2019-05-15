# i - $s0 
# j - $s1
.text
.globl main
main:
	# Colocar endereco base da memoria em t0
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16
	
	addi $s0,$zero,0 # comeca i = 0
	addi $t3,$zero,100 # Colocando t3 = 100
	
doPar: # Preenche o vetor de 100 
	# t1 = 2 * i
	sll $t1,$s0,1
	
	# vetor[i] = t1
	sll $t2,$s0,2
	add $t2,$t2,$t0
	sw $t1,0($t2)

	addi $s0,$s0,1 # i++
	
	# t1 != 100
	bne $t1,$t3,doPar
	j endWhilePar
	
endWhilePar:

addi $s1,$zero,0 # comeca j = 0
addi $t3,$zero,99 # Colocando t3 = 99	

doImpar: # Preenche o restante do vetor com impares até 100
	# t1 = 2 * j + 1
	sll $t1,$s1,1
	addi $t1,$t1,1
	
	add $t2,$s0,$s1 # i = i + j
	sll $t2,$t2,2
	add $t2,$t2,$t0
	sw $t1,0($t2)

	addi $s1,$s1,1 # j++

	slt $t4,$t1,$t3 # t4 = t1 < 99
	bne $t4,$zero,doImpar # while(j)