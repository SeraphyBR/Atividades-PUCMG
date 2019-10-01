.text
.globl main

main:
	# Colocar endereco base da memoria em s0
	addi $s0,$zero,0x1001
	sll  $s0,$s0,16

	# Obtem 'endereco' da memoria, e coloca em a0 para passagem de argumento
	lw $a0,0($s0)
	# Obtem 'tamanho_vetor' da memoria, e coloca em a1 para passagem de argumento 
	lw $a1,4($s0)
	
	jal new_vetor # new_vetor(a0,a1)
	add $s1,$zero,$v0 # s1 = retorno de new_vetor
	
	j fim_programa # encerra o programa

#------------------------------------------------
# new_vetor
# args: endereço, num
# descrição: Cria um vetor de tamanho 'num'
# 			 e preenche seguindo a regra 
#			-> y[i] = 2(i^2)+2i+1 se i for par; 
#			   y[i] = i^2 se i for impar.
# retorno: A soma de todos os elementos de y[]
new_vetor:
	add $s0,$zero,$a0 # s0 = a0 'endereco'
	add $s1,$zero,$a1 # s1 = a1 'tamanho_vetor'
	
	slti $t0,$s1,30 # t0 = 1 se s1 < 30, senão 0 s1 >= 30
	bne $t0,$zero,continue # se t0 != 0, continua, senao s1 = 30
	addi $s1,$zero,30
	continue:
	add $s2,$zero,$zero # Contador i
	add $s4,$zero,$zero # 'Somador'
	do:
		andi $t2,$s2,1 # obtem primeiro bit
		beq $t2,$zero,par # verifica se e par
		j impar
		par:
			sw $ra,0($sp) # salva $ra na pilha
			sw $a0,-4($sp) # salva $a0 na pilha
			sw $a1,-8($sp) # salva $a1 na pilha	
			addi $sp,$sp,-8 # Corrige o topo da pilha
			
			add $a0,$zero,$s2 # Coloca s2 no primeiro argumento da funcao
			jal ao_quadrado # chama a funcao 'ao_quadrado'
			
			lw $a1,0($sp) # resgata $a1 da pilha (que tá no topo)
			lw $a0,4($sp) # resgata $a0 da pilha
			lw $ra,8($sp) # resgata $ra da pilha
			addi $sp,$sp,8 # esvazia a pilha
						
			sll $t3,$v0,1 # t3 = 2 * $v0 = 2 * i^2
			sll $t4,$s2,1 # t4 = 2 * s2 = 2i
			addi $t4,$t4,1 # t4 = t4 + 1 = 2i + 1
			add $s3,$t3,$t4 # s3 = t3 + t4
			
			sll $t5,$s2,2
			add $t5,$t5,$s0 # t5 = *vet[i]
			sw $s3,0($t5) # vet[i] = $s3
			
			add $s4,$s4,$s3 # 'Somador' += s3
			j end

		impar:
			sw $ra,0($sp) # salva $ra na pilha
			sw $a0,-4($sp) # salva $a0 na pilha
			sw $a1,-8($sp) # salva $a1 na pilha	
			addi $sp,$sp,-8 # Corrige o topo da pilha
			
			add $a0,$zero,$s2 # Coloca s2 no primeiro argumento da funcao
			jal ao_quadrado # chama a funcao 'ao_quadrado'	
			
			lw $a1,0($sp) # resgata $a1 da pilha (que tá no topo)
			lw $a0,4($sp) # resgata $a0 da pilha
			lw $ra,8($sp) # resgata $ra da pilha
			addi $sp,$sp,8 # esvazia a pilha
			
			sll $t3,$s2,2
			add $t3,$t3,$s0 # t3 = *vet[i]
			sw $v0,0($t3) # vet[i] = v0
			
			add $s4,$s4,$v0 # 'Somador' += v0
		
		end:		
			addi $s2,$s2,1 # i++
			bne $s2,$s1,do # while(i != s2);
			add $v0,$zero,$s4 # return 'Somador'
			jr $ra
#------------------------------------------------

#--------------------------
# ao_quadrado
# args: num
# retorno: num^2
ao_quadrado:
	mult $a0,$a0
	mflo $v0
	jr $ra
#--------------------------

fim_programa:
	addi $v0,$zero,10 # Exit code return
	syscall 
	
.data
endereco: .word 0x10010000
tamanho_vetor: .word 30