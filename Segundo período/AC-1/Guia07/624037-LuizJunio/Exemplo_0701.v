// ------------------------- 
// Exemplo_0701 
// Nome: Luiz Junio Veloso Dos Santos 
// Matricula: 624037
// ------------------------- 
 
 
// ------------------------- 
//  Unidade Logica com AND e OR,
//  Simultaneas (paralelas, 2 respostas)
//  1-bit
// ------------------------- 
module lu (input  a, input  b, output s0, output s1); 
 
// descrever por portas 
 
   and AND1 ( s0, a, b ); 
   or OR1  ( s1, a, b ); 

endmodule // lu 
 
 
module main; 
// ------------------------- definir dados 
       reg  x; 
       reg  y;  
       wire s0; 
       wire s1; 
 
       lu LU1 (x, y, s0, s1); 
 
// ------------------------- parte principal 
 
   initial 
   begin : main 
        $display("Exemplo_0701 - Luiz Junio Veloso Dos Santos"); 
        $display("Test LU's module"); 
        $display("   x    y    s0   s1"); 
        // projetar testes do modulo 
        $monitor("%4b %4b %4b %4b", x, y, s0, s1); 
        x = 1'b0;  y = 1'b0; 
    #1  x = 1'b0;  y = 1'b1; 
    #1  x = 1'b1;  y = 1'b0; 
    #1  x = 1'b1;  y = 1'b1; 
   end 
 
endmodule // test_f6 
 

