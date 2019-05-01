.text
.globl teste
teste:	
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16 # t0 = primeiro endereco de dados
	
	lw $t1,12($t0) # t1 = mem[3]
	lw $t2,0($t1)  # t2 = mem(t1)
	lw $t3,0($t2)  # t3 = mem(t2)
	lw $t4,0($t3)  # t4 = 42 =  mem(t3)
	
	sll $t4,$t4,1 # t4 = t4 * 2
	sw $t4, 0($t3) # mem[t3] = t4
	
.data
k: .word 42
x: .word k
y: .word x
z: .word y



