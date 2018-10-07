// ------------------------- 
// Exemplo_0801 - FULL ADDER
// Nome: Luiz Junio Veloso Dos Santos 
// Matricula: 624037
// ------------------------- 


//-------------
// HALF ADDER
//-------------

module halfAdder (output s1, output s0, input a, input b);

    xor XOR1 ( s0, a, b );
    and AND1 ( s1, a, b );

endmodule // halfAdder

//-----------------
// FULL ADDER
//-----------------

module fullAdder (output s1, output s0, input Cin, input a, input b);

    wire s0a;
    wire s1a;
    wire s1b;

    halfAdder HALF1 ( s1a, s0a, a, b );
    halfAdder HALF2 ( s1b, s0, s0a, Cin );
    or OR ( s1, s1a, s1b );

endmodule // fullAdder
 
module test_fullAdder; 
// ------------------------- definir dados 
    reg   [3:0] x; 
    reg   [3:0] y; 
    wire  [3:0] carry; // “vai-um” 
    wire  [4:0] soma; 
 
   fullAdder  FA0 ( carry[0], soma[0], 1'b0, x[0], y[0] ); 
 
// ------------------------- parte principal 
 initial begin 
    $display("Exemplo0801 - Luiz Junio - 624037"); 
    $display("Test ALU’s full adder");
    $display("  Carry   x   y   soma");
    $monitor("%4b %4b %4b %4b", carry, x, y, soma);
        x = 3'b010; y = 3'b110;
    #1  x = 1'b0; y = 1'b1;
    #1  x = 1'b1; y = 1'b0;
    #1  x = 1'b1; y = 1'b1;
end 
 
endmodule // test_fullAdder 
 
