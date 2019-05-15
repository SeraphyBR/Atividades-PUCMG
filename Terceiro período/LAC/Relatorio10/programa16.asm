# i - $s0
# j - $s1
# z - $s2
.text
.globl main
main:
	# Colocar endereco base da memoria em t0
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16
	
	# Vetor desordenado
	addi $s2,$zero,100 # z = 100
	addi $t1,$zero,100
	do:
		sll $t9,$s2,2 # t9 = z * 4
		add $t9,$t9,$t0 # t9 = t9 + endereco base
		sub $t8,$t1,$s2 # t8 = 100 - z
		sw $t8,0($t9)
		addi $s2,$s2,-1 # z--
		bne $s2,$zero,do # while(z != 0)	
	
BubbleSort:
	addi $s0,$zero,0 # comeca i = 0
	addi $t1,$zero,99 # Colocando t1 = 99 (100 - 1) = Tamanho do Array - 1
 	for:
		slt $t7,$s0,$t1 # if (i < 99)
		beq $t7,$zero,endFor
	
		addi $s1,$zero,0 # j = 0
		for2:
			sub $t2,$t1,$s0 # t2 = 99 - i
			slt $t3,$s1,$t2 # if (j < 99 - i)
			beq $t3,$zero,endFor2
		
			sll $t4,$s1,2
			add $t4,$t4,$t0
			lw $t5,0($t4) # t5 = A[J]
			lw $t6,4($t4) # t6 = A[J + 1]
			slt $t7,$t6,$t5 # if (t5 > t6)
			beq $t7,$zero,pula
	    	# swap
			sw $t5,4($t4) # A[J + 1] = t5
			sw $t6,0($t4) # A[J] = t6
			pula:
			addi $s1,$s1,1 # j++
			j for2
			endFor2:
			addi $s0,$s0,1 # i++
			j for
	endFor: