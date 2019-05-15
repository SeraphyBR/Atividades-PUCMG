# x - $s0
# y - $s1
# z - $s2
# resultado - $s3
.text
.globl main
main:
	addi $t0,$zero,0x0018
	sll $t0,$t0,16
	ori $s0,$t0,0x6A00 # x = 0x186A00
	
	addi $t0,$zero,0x0001
	sll $t0,$t0,16
	ori $s1,$t0,0x3880 # y = 0x13880
	
	addi $t0,$zero,0x0006
	sll $t0,$t0,16
	ori $s2,$t0,0x1A80 # z = 0x61A80
	
	div $s0,$s2
	mflo $t1 # t1 = x / z
	mult $t1,$s1 
	mflo $s3 # resultado = t1 * y