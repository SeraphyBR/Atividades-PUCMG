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
//  Unidade Logica com AND e OR,
//  Selecionavel (paralelas, 1 resposta)
//  1-bit
// ------------------------- 
module lu (output sa, output sb, input key, input a, input b); 
    
    wire s0, s1, s2, s3;

    // descrever por portas 
    and AND1   ( s0, a, b );
    nand NAND1 ( s1, a, b );
    or  OR1    ( s2, a, b );
    nor NOR1   ( s3, a, b );

    mux MUX1 (sa, key, s0, s1);
    mux MUX2 (sb, key, s2, s3);

endmodule // mux 
 
 
module main; 
// ------------------------- definir dados 
       reg  x; 
       reg  y;
       reg key;
       wire s0;
       wire s1;
 
       lu LU1 (s0, s1, key, x, y); 
 
// ------------------------- parte principal 
 
   initial 
   begin : main 
        $display("Exemplo_0703 - Luiz Junio Veloso Dos Santos"); 
        $display("Test LU's module"); 
        $display("  key   x    y    s0    s1"); 
        // projetar testes do modulo 
        $monitor("%4b %4b %4b %4b %4b", key, x, y, s0, s1); 
        key = 1'b0;  x = 1'b0; y = 1'b0; 
    #1  key = 1'b0;  x = 1'b0; y = 1'b1;
    #1  key = 1'b0;  x = 1'b1; y = 1'b0;
    #1  key = 1'b0;  x = 1'b1; y = 1'b1;
    #1  key = 1'b1;  x = 1'b0; y = 1'b0;
    #1  key = 1'b1;  x = 1'b0; y = 1'b1;
    #1  key = 1'b1;  x = 1'b1; y = 1'b0;
    #1  key = 1'b1;  x = 1'b1; y = 1'b1;
   end 
 
endmodule // test_f6 
 

