# endereço base - $s0
.text
.globl main
main:
	# Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	
	# Verifica se X é par ou impar
	lw $t1,0($s0) # t1 = X
	slt $t2,$zero,$t1 # if (x > 0)
	bne $t2,$zero,maior # goto maior
	j menorIgual		# else goto menorIgual
	
	maior:
		mult $t1,$t1 # x * x
		mflo $t2 # t2 = x^2
		mult $t2,$t1 # x^2 * X
		mflo $t3 # t3 = x^3
		addi $t3,$t3,1 # t3 = x^3 + 1
		sw $t3,4($s0)
		j fim
	
	menorIgual:
		mult $t1,$t1 # x * x
		mflo $t2 # t2 = x^2
		mult $t2,$t1 # x^2 * X
		mflo $t3 # t3 = x^3
		mult $t3,$t1 # x^3 * x
		mflo $t4 # t4 = x^4
		addi $t4,$t4,-1 # t4 = x^4 - 1
		sw $t4,4($s0)
		
	fim:
	
.data
X: .word 42
Y: .word 0