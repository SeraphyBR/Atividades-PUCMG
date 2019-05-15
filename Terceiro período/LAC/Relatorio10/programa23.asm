#Endereco base - $s0
.text
.globl main

main:
    # Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16



.data
X: .word 4
Y: .word 2
K: .word 0