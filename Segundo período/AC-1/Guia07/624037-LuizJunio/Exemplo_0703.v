// -------------------------
// Exemplo_0703
// Nome: Luiz Junio Veloso Dos Santos
// Matricula: 624037
// -------------------------



// -------------------------
//  multiplexer
// -------------------------
module mux (output s, input key, input a, input b);

// definir dados locais
   wire sa;
   wire sb;
   wire notKey;

   not NOT1 ( notKey, key );
   and AND1 ( sa, a, notKey );
   and AND2 ( sb, b, key );

   or OR1 (s, sa, sb);
endmodule //mux

// -------------------------
//  Unidade Logica com AND/OR e NAND/NOR
//  Selecionavel (paralelas, 1 resposta)
//  1-bit
// -------------------------
module lu (output s, input key, input keyb, input a, input b);

    wire s0, s1, s2, s3, sa, sb;

    // descrever por portas
    and AND1   ( s0, a, b );
    nand NAND1 ( s1, a, b );
    or  OR1    ( s2, a, b );
    nor NOR1   ( s3, a, b );

    mux MUX1 (sa, key, s0, s2);
    mux MUX2 (sb, key, s1, s3);
    mux MUX3 (s, keyb, sa, sb);

endmodule // mux


module main;
// ------------------------- definir dados
       reg  x;
       reg  y;
       reg key;
       reg keyb;
       wire s;

       lu LU1 (s, key, keyb,  x, y);

// ------------------------- parte principal

   initial
   begin : main
        $display("Exemplo_0703 - Luiz Junio Veloso Dos Santos");
        $display("Test LU's module");
        $display("  keyb key   x    y    s");
        // projetar testes do modulo
        $monitor("%4b %4b %4b %4b %4b", keyb, key, x, y, s);
        keyb = 1'b0; key = 1'b0;  x = 1'b0; y = 1'b0;
    #1  keyb = 1'b0; key = 1'b0;  x = 1'b0; y = 1'b1;
    #1  keyb = 1'b0; key = 1'b0;  x = 1'b1; y = 1'b0;
    #1  keyb = 1'b0; key = 1'b0;  x = 1'b1; y = 1'b1;
    #1  keyb = 1'b0; key = 1'b1;  x = 1'b0; y = 1'b0;
    #1  keyb = 1'b0; key = 1'b1;  x = 1'b0; y = 1'b1;
    #1  keyb = 1'b0; key = 1'b1;  x = 1'b1; y = 1'b0;
    #1  keyb = 1'b0; key = 1'b1;  x = 1'b1; y = 1'b1;
    #1  keyb = 1'b1; key = 1'b0;  x = 1'b0; y = 1'b0;
    #1  keyb = 1'b1; key = 1'b0;  x = 1'b0; y = 1'b1;
    #1  keyb = 1'b1; key = 1'b0;  x = 1'b1; y = 1'b0;
    #1  keyb = 1'b1; key = 1'b0;  x = 1'b1; y = 1'b1;
    #1  keyb = 1'b1; key = 1'b1;  x = 1'b0; y = 1'b0;
    #1  keyb = 1'b1; key = 1'b1;  x = 1'b0; y = 1'b1;
    #1  keyb = 1'b1; key = 1'b1;  x = 1'b1; y = 1'b0;
    #1  keyb = 1'b1; key = 1'b1;  x = 1'b1; y = 1'b1;
   end

endmodule // test_f6
