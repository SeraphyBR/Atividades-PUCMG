
# x1 - $s0
# x2 - $s1
# x3 - $s2


.text
.globl main
main:
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 
	
	lw $s0,0($t0) #
	lw $s1,4($t0) #
	
	add $s2,$s0,$s1
	sw $s2,8($t0) 
		
.data
x1: .word 1
x2: .word 3
x3: .word 5
x4: .word 7