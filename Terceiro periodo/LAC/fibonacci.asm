# Endereco base - $s0
# i - $s1
.text
.globl main
main:
	# Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	
	addi $t0,$zero,46
	
	addi $t1,$zero,1
	sw $t1,0($s0) # A[0] = 1
	sw $t1,4($s0) # A[1] = 1
	
	addi $s1,$zero,2 # i = 2 
	do:
		sll $t2,$s1,2
		add $t2,$t2,$s0
		lw $t3,-4($t2) # t3 = A[i-1]
		lw $t4,-8($t2) # t4 = A[i-2]
		
		add $t5,$t4,$t3 # t5 = t5 + t4
		sw $t5,0($t2) # A[i] = t6
		
		addi $s1,$s1,1 # i++
		bne $t0,$s1,do