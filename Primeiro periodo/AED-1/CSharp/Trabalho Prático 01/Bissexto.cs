using System;

public class Bissexto {
    public static void Main(){
        Console.Write("Digite um ano: ");
        int ano = Convert.ToInt32(Console.ReadLine());
        if((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))){
            Console.WriteLine($"O ano {ano} é bissexto.");
        }
        else {
            Console.WriteLine($"O ano {ano} não é bissexto.");
        }
    }
}