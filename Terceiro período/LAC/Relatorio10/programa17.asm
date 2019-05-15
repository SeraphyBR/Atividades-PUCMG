
.text
.globl main
main:
	# Colocar endereco base da memoria em t0
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16
	
	lw $t1,0($t0) # t2 = X
	
	# Verifica se é par ou impar
	andi $t2,$t1,1 # Isola o primeiro bit
	beq $t2,$zero,par # if(t2 == 0) goto par
	j impar			  # else goto impar
	
	par:
		mult $t1,$t1
		mflo $t1
	impar:
	
	fim:

.data
X: .word 42
Y: .word 0