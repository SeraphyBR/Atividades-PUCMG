/*
 * Autor: Luiz Junio <luisjuniorbr@gmail.com>
 * Enunciado:
 *  Arquivo em Java: Faca um programa que leia um numero inteiro n indicando o numero de
 *  valores reais que devem ser lidos e salvos sequencialmente em um arquivo texto. Apos a leitura
 *  dos valores, devemos fechar o arquivo. Em seguida, reabri-lo e fazer a leitura de tras para frente
 *  usando os metodos getFilePointer e seek da classe RandomAccessFile e mostre todos os valores
 *  lidos na tela. Nessa questao, voce nao pode usar, arrays, strings ou qualquer estrutura de dados.
 *  A entrada padrao e composta por um numero inteiro n e mais n numeros reais. A saida padrao
 *  corresponde a n numeros reais mostrados um por linha de saıda.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Arquivo
{//Inicio classe Arquivo
    public static void main(String[] args)
    {//Inicio main
        try
        {//Inicio try

            RandomAccessFile file = new RandomAccessFile("numeros.txt", "rw");
            int numEntrada = MyIO.readInt();
            double valor;
            for(int i = 0; i < numEntrada; i++)
            {//Inicio for
                file.writeDouble(MyIO.readDouble());
            }//Fim for

            file.close();//Fecha o arquivo

            file = new RandomAccessFile("numeros.txt", "r");

            for(int i = 0; i < numEntrada; i++)
            {
                file.seek(((numEntrada - i - 1) * 8 ));
                valor = file.readDouble();
                if(valor % 1 == 0)
                    MyIO.println((int) valor);
                else
                    MyIO.println(valor);
            }

            file.close();

        }//Fim try
        catch(FileNotFoundException fileNotFoundException){
            System.out.println(fileNotFoundException);
        }
        catch(IOException ioException){
            System.out.println(ioException);
        }

    }//Fim main 




}//Fim classe Arquivo
