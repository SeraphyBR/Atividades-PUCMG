# x - $s1
# y - $s2
# z - $s3
# w - $s4

.text
.globl teste
teste:	
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 # t0 = primeiro endereco de dados
	
	lw $s1,0($t0) # x = mem[0]
	lw $s2,4($t0) # y = mem[1]
	lw $s3,8($t0) # z = mem[2]
	lw $s4,12($t0) # z = mem[3]
	
	add $t1,$s1,$s2 # t1 = x + y
	add $t1,$t1,$s3 # t1 = t1 + z
	add $t1,$t1,$s4 # t1 = t1 + w
	
	sw $t1,16($t0) # soma = t1
	
.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
soma: .word -1
