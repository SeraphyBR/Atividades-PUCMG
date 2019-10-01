
## Inicio
.text
.globl main
main:
	ori $8, $0, 0x01
	nor $9, $8, $8
	or  $8, $9, $8
	