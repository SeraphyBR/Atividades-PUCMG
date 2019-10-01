/*
 * Prova2.java
 * Copyright (C) 2019 seraphybr-fun <seraphybr-fun@funtoo-z40>
 *
 * Distributed under terms of the MIT license.
 */
import java.util.Scanner;

public class Prova2
{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a,b,c;
        int cont = 0;
        System.out.print("Digite o valor do for1: ");
        a = reader.nextInt();
        System.out.print("Digite o valor do for2: ");
        b = reader.nextInt();
        System.out.print("Digite o valor do for3: ");
        c = reader.nextInt();
        reader.close();
        do {
            do {
                do {
                    cont++;
                    c--;
                } while (c != 0);
                b--;
            } while (b != 0);
            a--;
        } while (a != 0);

        System.out.println("a = " + a + " b = " + b + " c = " + c + " cont = " + cont);
    }
}
