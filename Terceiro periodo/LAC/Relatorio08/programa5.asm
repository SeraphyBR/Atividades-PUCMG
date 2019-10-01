# x - $s0
# y - $s1
# z - $s2

## Inicio

.text
.globl main

main:
	addi $t0,$zero,6250 # t0 = 6250
	sll  $s0,$t0,4 		# x = t0 * 2^4 = 100000
	sll  $s1,$t0,5      # t0 = 100000 * 2^5 = 200000 
	add $s2,$s0,$s1     # z = x + y