
# x - $s0
# y - $s1
# z - $s2

## Inicio

.text
.globl main

main:
	addi $s0,$zero,3 # x = 3
	addi $s1,$zero,4 # y = 4
	
	add  $t0,$s0,$s0 # t0 = x + x
	add  $t0,$s0,$s0 # t0 = 2x + 2x
	add  $t0,$s0,$s0 # t0 = 4x + 4x
	add  $t0,$s0,$s0 # t0 = 8x + 8x
	sub  $t0,$t0,$s0  # to = 16x - x
	
	add  $t1,$s1,$s1 # t1 = y + y
	add  $t1,$t1,$t1 # t1 = 2y + 2y
	add  $t1,$t1,$t1 # t1 = 4y + 4y
	add  $t1,$t1,$t1 # t1 = 8y + 8y
	add  $t1,$t1,$t1 # t1 = 16y + 16y
	add  $t1,$t1,$t1 # t1 = 32y + 32y
	add  $t1,$t1,$s1 # t1 = 64y + y
	add  $t1,$t1,$s1 # t1 = 65y + y
	add  $t1,$t1,$s1 # t1 = 66y + y
	add  $t1,$t1,$s1 # t1 = 67y + y
	
	add  $t2,$t0,$t1 # t2 = 15x + 67y
	add  $t2,$t2,$t2 # t2 = t2 + t2
	add  $t2,$t2,$t2 # t2 = 2*t2 + 2*t2
	
	add  $s2,$zero,$t2 # z = t2
	 	 
