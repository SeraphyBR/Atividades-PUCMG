// ------------------------- 
// Exemplo_0803 - Igualdade
// Nome: Luiz Junio Veloso Dos Santos 
// Matricula: 624037
// ------------------------- 

module fullIgualdade (output s, input [3:0]a, input [3:0]b);

    wire s0,s1,s2,s3;

    xnor XOR1 ( s0, a[0], b[0] );
    xnor XOR2 ( s1, a[1], b[1] );
    xnor XOR3 ( s2, a[2], b[2] );
    xnor XOR4 ( s3, a[3], b[3] );
    and  AND1 ( s, s0, s1, s2, s3 );

endmodule 

module test; 
// ------------------------- definir dados 
    reg   [3:0] x; 
    reg   [3:0] y;
    wire        s;
    fullIgualdade FI ( s, x, y ); 
 
// ------------------------- parte principal 
 initial begin 
    $display("Exemplo0803 - Luiz Junio - 624037"); 
    $display("Test ALU’s Igualdade");
    $display("      x        y     s");
    $monitor("  %4b      %4b     %1b", x, y, s);
        x = 4'b0100; y = 4'b0011;
    #1  x = 4'b0110; y = 4'b0110;
end 
 
endmodule // test_fullAdder 
 
