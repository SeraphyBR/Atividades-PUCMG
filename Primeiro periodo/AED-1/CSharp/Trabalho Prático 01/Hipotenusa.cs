using System;

public class Hipotenusa {
    public static void Main(){
        Console.Write("O seguinte programa calcula a hipotenusa ");
        Console.WriteLine("de um triângulo retângulo.");
        Console.Write("Digite o primeiro cateto: ");
        double catetoA = Convert.ToDouble(Console.ReadLine());
        Console.Write("Digite o segundo cateto: ");
        double catetoB = Convert.ToDouble(Console.ReadLine());
        double hipotenusa = Math.Sqrt((Math.Pow(catetoA, 2) + (Math.Pow(catetoB, 2))));
        Console.WriteLine($"O valor da hipotenusa é: {hipotenusa}");
    }
}