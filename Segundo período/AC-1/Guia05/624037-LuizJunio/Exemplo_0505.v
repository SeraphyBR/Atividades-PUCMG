
// ------------------------- 
// Exemplo_0505 
// Nome: Luiz Junio Veloso Dos Santos
// Matricula: 624037
// ------------------------- 
 
 
// ------------------------- 
//  f5_gate 
//  m  a  b  s 
//  0  0  0  0 
//  1  0  1  1 <- a'.b 
//  2  1  0  0 
//  3  1  1  0 
// 
// ------------------------- 
module nor1 ( output s, 
                    input  a, 
                    input  b ); 
// descrever por expressao 
   assign s = ~(a | b); 
endmodule // f5b 

module main; 
// ------------------------- definir dados 
       reg  x; 
       reg  y; 
       wire a;
       wire s1;
 
       nor1 moduloA ( s1, x, y );
       nor1 moduloR (a, s1, s1);
 
// ------------------------- parte principal 
 
   initial 
   begin : main 
          $display("Questao04 - Luiz Junio Veloso Dos Santos - 624037"); 
          $display("Disjuncao (a | b)"); 
          $display("   x    y    a "); 
 
       // projetar testes do modulo 
         $monitor("%4b %4b %4b", x, y, a); 
            x = 1'b0;  y = 1'b0; 
   #1      x = 1'b0;  y = 1'b1; 
   #1      x = 1'b1;  y = 1'b0; 
   #1      x = 1'b1;  y = 1'b1; 
 
   end 
 
endmodule // test_f5 
 
 
