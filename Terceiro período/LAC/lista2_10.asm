.text
.globl main
main:
	# Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16
	lw $s1,0($s0)
	
	# Verifica se eh >= 50
	addi $t1,$zero,50
	slt $t1,$s1,$t1 # 1 se for < 50, 0 se for >= 50
	beq $t1,$zero,teste2
	j zero
	
	teste2:
		#Verifica se eh <= 100
		addi $t2,$zero,100
		slt $t2,$t2,$s1 # 1 se for > 100, 0 se for <= 100
		beq $t2,$zero,um
		j teste3
		
	teste3:
		# Verifica se eh >= 150
		addi $t1,$zero,150
		slt $t1,$s1,$t1 # 1 se for < 150, 0 se for >= 150
		beq $t1,$zero,teste4
		j zero
	
	teste4:
		#Verifica se eh <= 200
		addi $t2,$zero,200
		slt $t2,$t2,$s1 # 1 se for > 200, 0 se for <= 200
		beq $t2,$zero,um
		j zero
		
	um: 
		addi $t0,$zero,1
		j fim
		
	zero:
		addi $t0,$zero,0
		j fim
		
	fim:
	
.data
numero: .word 53