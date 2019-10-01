# endereço base - $s0
.text
.globl main
main:
	# Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	
	# Verifica se X é par ou impar
	lw $t1,0($s0) # t1 = X
	andi $t2,$t1,1 # Isola o primeiro bit
	beq $t2,$zero,par # if(t2 == 0) goto par
	j impar			  # else goto impar
	
	par:
		mult $t1,$t1 # x * x
		mflo $t2 # t2 = x^2
		mult $t2,$t1 # x^2 * X
		mflo $t3 # t3 = x^3
		mult $t3,$t1 # x^3 * x
		mflo $t4 # t4 = x^4
		
		add $t5,$t4,$t3 # t5 = x^4 + x^3
		sll $t2,$t2,1   # t2 = x^2 * 2
		sub $t5,$t5,$t2 # t5 = t5 - t2
		sw $t5,4($s0)   # Y = t5
		j fim
	impar:
		mult $t1,$t1 # x * x
		mflo $t2 # t2 = x^2 
		mult $t2,$t1 # x^2 * X
		mflo $t3 # t3 = x^3
		mult $t3,$t1 # x^3 * x
		mflo $t4 # t4 = x^4
		mult $t4,$t1 # x^4 * x
		mflo $t5 # t5 = x^5
		
		sub $t5,$t5,$t3 # t5 = x^5 - x^3
		addi $t5,$t5,1 # t5 = t5 + 1
		sw $t5,4($s0) # Y = t5
	fim:

.data
X: .word 42
Y: .word 0