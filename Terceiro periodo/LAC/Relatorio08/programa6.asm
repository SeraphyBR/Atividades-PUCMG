# x - $s0
# y - $s1
# z - $s2

## Inicio

.text
.globl main

main:
	addi $s0,$zero,32767 # x = 32767
	addi $t0,$zero,18750 # t0 = 18750
	sll  $s1,$t0,4       # y = 18750 * 2^4 = 300000
	sll  $t0,$s1,2       # t0 = y * 2^2 = 4y 
	sub $s2,$s0,$t0      # z = x - 4y