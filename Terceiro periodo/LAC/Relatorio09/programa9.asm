# x mapeado em $s1
.text
.globl teste
teste:
	
	addi $s1,$zero,1 # x = 1
	lw $s1, 0($t0)
	
.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
