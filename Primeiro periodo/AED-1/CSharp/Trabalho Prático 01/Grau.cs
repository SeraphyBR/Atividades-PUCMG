using System;

public class Grau {
    public static void Main(){
        Console.Write("Digite um grau em fahrenheit: ");
        double grauf = Convert.ToDouble(Console.ReadLine());
        double grauc = 5.0 / 9 * (grauf - 32);
        Console.WriteLine("O grau em celcius é: {0:F2}°C", grauc);
    }
}