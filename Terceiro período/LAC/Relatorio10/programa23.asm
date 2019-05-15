#Endereco base - $s0
# i - $s1
.text
.globl main
main:
    # Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	
	lw $t0,0($s0) # t0 = X
	lw $t1,4($s0) # t0 = Y

	addi $s1,$zero,1 # i = 1
	add $t2,$zero,$t0 # t2 = 0
	do:
		mult $t2,$t0
		mflo $t2 # t2 = t2 * X
		addi $s1,$s1,1 # i++ 
		slt $t3,$s1,$t1 # t3 = i < Y
		bne $t3,$zero,do # while(t3)
		sw $t2,8($s0) # K = t2
.data
X: .word 2
Y: .word 5
K: .word 0