using System;

public class AreaCirculo {
    public static void Main(){
        Console.Write("Digite o raio do circulo: ");
        double raio = Convert.ToDouble(Console.ReadLine());
        double area = Math.PI * Math.Pow(raio,2);
        Console.WriteLine($"A área do circulo é: {area}");
    }
}