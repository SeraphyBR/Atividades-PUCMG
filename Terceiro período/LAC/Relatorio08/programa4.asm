# x - $s0
# y - $s1
# z - $s2

## Inicio

.text
.globl main

main:
	addi $s0,$zero,3 # x = 3
	addi $s1,$zero,4 # y = 4
	
	sll $t0,$s0,4   # t0 = x * 2^4
	sub $t0,$t0,$s0 # t0 = 16x - x
	
	sll $t1,$s1,6   # t1 = y * 2^6
	add $t1,$t1,$s1 # t1 = 64y + y
	add $t1,$t1,$s1 # t1 = 65y + y
	add $t1,$t1,$s1 # t1 = 66y + y
	
	add $t2,$t0,$t1 # t2 = t0 + t1
	sll $t2,$t2,2   # t2 = t2 * 2^2
	
	add  $s2,$zero,$t2 # z = t2
	 	 
