## Inicio
.text
.globl main
main:
	ori $t5,$zero,0x1234 # t5 = 0x1234
	sll $t5,$t5,16       # t5 = 0x12340000
	ori $t5,$t5,0x5678   # t5 = 0x12340000 + 0x5678
	or $8,$zero,$t5      # t0 = 0x12345678
	
	srl $9,$t5,24  # t1 = 0x12
	
	sll $t6,$t5,8  # t6 = 0x34567800
	srl $10,$t6,24 # t2 = 0x34
	
	sll $t6,$t6,8  # t6 = 0x56780000
	srl $11,$t6,24 # t3 = 0x56
	
	sll $t6,$t6,8  # t6 = 0x78000000
	srl $12,$t6,24 # t4 = 0x78