// ------------------------- 
// Exemplo_0702 
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
   and AND1 ( sa, a, key );
   and AND2 ( sb, b, notKey );

   or OR1 (s, sa, sb);
endmodule //mux

// ------------------------- 
//  Unidade Logica com AND e OR,
//  Selecionavel (paralelas, 1 resposta)
//  1-bit
// ------------------------- 
module lu (output s, input key, input a, input b); 
    
    wire s0;
    wire s1;

    // descrever por portas 
    and AND1 ( s0, a, b ); 
    or  OR1  ( s1, a, b );
    mux MUX1 (s, key, s0, s1);

endmodule // mux 
 
 
module main; 
// ------------------------- definir dados 
       reg  x; 
       reg  y;
       reg key;
       output s;
 
       lu LU1 (s, key, x, y); 
 
// ------------------------- parte principal 
 
   initial 
   begin : main 
        $display("Exemplo_0702 - Luiz Junio Veloso Dos Santos"); 
        $display("Test LU's module"); 
        $display("   key    x    y   s"); 
        // projetar testes do modulo 
        $monitor("%4b %4b %4b %4b", key, x, y, s); 
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
 

