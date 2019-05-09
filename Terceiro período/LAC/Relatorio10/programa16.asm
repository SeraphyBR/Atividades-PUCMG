
# i - $s0
# j - $s1

.text
.globl main

main:
	# Colocar endereco base da memoria em t0
	addi $t0,$zero,0x1001
	sll  $t0,$t0,16
	
	addi $s0,$zero,0 # comeca i = 0
	addi $t1,$zero,100 # Colocando t1 = 100

for:
	
	addi $s1,$zero,0 # j = 0
	for2:
	sll