
# x - $s0
# y - $s1

## Inicio

.text
.globl main

main:
	addi $s0,$zero,1 # x = 1
	add $t0,$s0,$s0 # t0 = x + x
	add $t0,$t0,$t0 # t0 = 2x + 2x
	add $t0,$t0,$s0 # t0 = t0 + x
	addi $s1,$t0,15 # y = t0 + 15	 