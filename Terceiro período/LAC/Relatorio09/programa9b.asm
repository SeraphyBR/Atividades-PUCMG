# x mapeado em $s1
.text
.globl teste
teste:
	addi $s1,$zero,1 # x = 1
	
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 # t0 = primeiro endereco de dados
	
	lw $s1,0($t0) # s1 = mem[0]
	lw $s2,4($t0) # s2 = mem[1]
	lw $s3,8($t0) # s3 = mem[2]
	lw $s4,12($t0) # s4 = mem[3]
	
.data
x1: .word 15
x2: .word 25
x3: .word 13
x4: .word 17
