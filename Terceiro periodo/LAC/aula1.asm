
# x - $s0
# y - $s1
# z - $s2

## Inicio

.text

.globl main

main:
    sub  $t0, $t0, $t0 # t0 = 0
    addi $s0, $t0, 1   # x = 1
    addi $s1, $t0, 2   # y = 2
    sub  $s2, $s0, $s1 # z = x - y
