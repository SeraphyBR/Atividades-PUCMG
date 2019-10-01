
// -------------------------
// Exemplo_0507
// Nome: Luiz Junio Veloso Dos Santos
// Matricula: 624037
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
       wire s2;
       wire s3;
       wire s4;
       wire s5;

       nor1 Nor1 ( s1, x, y );
       nor1 Nor2 (s2, x, x);
       nor1 Nor3 (s3, y, y);
       nor1 Nor4 (s4, s2, s3);
       nor1 Nor5 (s5, s4, s1);
       nor1 Nor6 (a, s5, s5);

// ------------------------- parte principal

   initial
   begin : main
          $display("Questao06 - Luiz Junio Veloso Dos Santos - 624037");
          $display("Negacao da disjuncao exclusiva ~(a ^ b)");
          $display("   x    y    a ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b", x, y, a);
            x = 1'b0;  y = 1'b0;
   #1      x = 1'b0;  y = 1'b1;
   #1      x = 1'b1;  y = 1'b0;
   #1      x = 1'b1;  y = 1'b1;

   end

endmodule // test_f5
