
// -------------------------
// Questao 01
// Nome: Luiz Junio Veloso Dos Santos
// Matricula: 624037
// -------------------------


module letraA ( output s,
                    input  x,
                    input  y,
                    input z);
// descrever por expressao
   assign s = (~y & z) | (x & z);
endmodule

module letraB ( output s,
                    input  x,
                    input  y,
                    input z);
// descrever por expressao
   assign s = (~z & y) | (~x & ~y & ~z);
endmodule

module letraC ( output s,
                    input  x,
                    input  y,
                    input z);
// descrever por expressao
   assign s = ~y;
endmodule

module letraD ( output s,
                    input  x,
                    input  y,
                    input z);
// descrever por expressao
   assign s = (~x & y ) | (x & z);
endmodule

module letraE ( output s,
                    input  x,
                    input  y,
                    input z);
// descrever por expressao
   assign s = (~y & ~z) | (x & ~y) | (~x & y & z) | (x & ~z);
endmodule

module main;
// ------------------------- definir dados
       reg  x;
       reg  y;
       reg  z;
       wire s,s0,s1,s2,s3;


       letraA LetraA (s, x, y, z);
       letraB LetraB (s0, x, y, z);
       letraC LetraC (s1, x, y, z);
       letraD LetraD (s2, x, y, z);
       letraE LetraE (s3, x, y, z);
// ------------------------- parte principal

   initial
   begin : main
          $display("Questao01 - Luiz Junio Veloso Dos Santos - 624037");
          $display("Letra A:");
          $display("   x    y    z    s ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b %4b", x, y, z, s);
           x = 1'b0;  y = 1'b0; z = 1'b0;
   #1      x = 1'b0;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b1;

          $display("Letra B:");
          $display("   x    y    z    s ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b %4b", x, y, z, s0);
           x = 1'b0;  y = 1'b0; z = 1'b0;
   #1      x = 1'b0;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b1;

          $display("Letra C:");
          $display("   x    y    z    s ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b %4b", x, y, z, s1);
           x = 1'b0;  y = 1'b0; z = 1'b0;
   #1      x = 1'b0;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b1;

          $display("Letra D:");
          $display("   x    y    z    s ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b %4b", x, y, z, s2);
           x = 1'b0;  y = 1'b0; z = 1'b0;
   #1      x = 1'b0;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b1;

          $display("Letra E:");
          $display("   x    y    z    s ");

       // projetar testes do modulo
         $monitor("%4b %4b %4b %4b", x, y, z, s3);
           x = 1'b0;  y = 1'b0; z = 1'b0;
   #1      x = 1'b0;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b0;  y = 1'b1;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b0;  z = 1'b1;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b0;
   #1      x = 1'b1;  y = 1'b1;  z = 1'b1;

   end

endmodule // test_f5
