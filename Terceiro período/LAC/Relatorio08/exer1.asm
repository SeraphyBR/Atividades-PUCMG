
# x - $s0
# y - $s1

.text
.globl main
main:
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 
	
	lw $s0,0($t0) # x = primeiro endereço de dados
	
	sll $t1,$s0,6 # t0 = x * 2^6
	add $t1,$t1,$s0 # t0 = 64x + x
	add $t1,$t1,$s0 # t0 = 65x + x
	add $t1,$t1,$s0 # t0 = 66x + x
	
	addi $s1,$t1,1 # y = t0 + 1
	sw $s1,4($t0) 
	
.data
x: .word 1
y: .word 0