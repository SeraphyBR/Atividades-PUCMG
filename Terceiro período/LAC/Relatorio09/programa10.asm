# x - $s1
# z - $s2

.text
.globl teste
teste:	
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 # t0 = primeiro endereco de dados
	
	lw $s1,0($t0) # x = mem[0]
	lw $s2,4($t0) # z = mem[1]
	
	sub $t1,$s1,$s2 # t1 = x - y
	addi $t2,$zero,100000
	addi $t1,$t1,1 # t3 = t3 + 1
	
	sw $t3,8($t0) # y = t1
	
.data
x: .word 100000
z: .word 200000
y: .word 0
