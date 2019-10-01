#Endereco base - $s0
.text
.globl main
main:
    # Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	
	lw $t0,0($s0) # t0 = A[0] = X
	lw $t1,4($s0) # t1 = A[1] = Y
	mult $t0,$t1
	mflo $t2      # t2 = t0 * t1
	sw $t2,8($s0) # K = A[2] = t2
.data
X: .word 4
Y: .word 2
K: .word 0