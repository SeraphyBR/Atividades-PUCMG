
/// Algoritmo de treinamento back-propagation para redes multicamadas

#include <iostream>
#include <vector>
#include <cmath>
#include <stdlib.h>
#include <stdio.h>

// Número máximo de camadas
#define MAXCAM          5

// Número máximo de neurônios
#define MAXNEU          100

// Número máximo de pesos
#define MAXPES          100

// Número máximo de linhas
#define MAXLIN          100

// Número máximo de colunas
#define MAXCOL          20

// Número de Linhas da Matriz de Entrada
#define NUMLIN          26

// Número de Colunas da Matriz de Entrada
#define NUMCOLENT       8

// Número de Colunas de Saida
#define NUMCOLSAI       5

// Numero de Iteracoes
#define NUMITE          1

// Número de erros consecutivos
#define TOLERANCIA	0.00001

#define ESC             27

#define MI              0.6

// Fator de ajuste das correcoes
double BETA = MI;

//*********************** NEURÔNIO ******************************/

// Classe que representa um neurônio
class Neuronio
{
    private:
        // Número de pesos do neurônio
        int numero_pesos;
        // Vetor de pesos
        double W[MAXPES];

    public:
        // Inicia os valores dos pesos
        void inicializar(int numero_pesos);
        // Ajusta os valores dos pesos
        void ajustar_peso(double entrada, double erro, int indice_peso);
        // Retorna os pesos e quantos são
        double somatorio(double entrada[]);
        double erro_peso(double erro, int indice_peso);
};

// Inicializa o Número de Pesos e também os valores
// iniciais dos pesos
void Neuronio::inicializar(int numero_pesos)
{
    this->numero_pesos = numero_pesos;

    for (int i = 0; i < numero_pesos; i++)
        W[i] = (double)(rand() % 11/10.0) * (rand() % 3 - 1);
}

// Multilica o Erro da saída de um neurônio por um Peso de
// Indice_Peso
double Neuronio::erro_peso(double erro, int indice_peso)
{
    return erro * W[indice_peso];
}

// Dada uma entrada, retorna a saída do neurônio
// multiplicando-a pelos pesos
double Neuronio::somatorio(double entrada[])
{
    double resultado = 0;
    // Não descomente a linha abaixo
    //#pragma omp parallel for private(i) reduction(+:Som) num_threads(4)
    for (int i = 0; i < this->numero_pesos; i++)
        resultado += entrada[i] * W[i];

    return resultado;
}

// Dado o erro da camada da frente, a saída do neurônio,
// e Indice do Peso, calcula-se o novo peso
void Neuronio::ajustar_peso(double entrada, double erro, int indice_peso)
{
    W[indice_peso] += BETA * erro * entrada;
}

//*********************** CAMADA ******************************/

// Classe que representa um conjunto de neurônios
class Camada
{
    private:
        // Número de neurônios na camada
        int numero_neuronios;
        int numero_pesos;
        // Saída dos neurônios da camada
        double saida[MAXNEU];
        // Neurônios da camada
        Neuronio N[MAXNEU];

    public:
        // Atribui o número de neurônios
        void inicializar(int numero_neuronios, int numero_pesos);
        // Treina os neurônios com uma entrada
        void treinar_neuronios(double entrada[]);
        // Joga saída linear na funcao de ativacao
        void funcao_ativacao();
        // Retorna a saída dos neurônios
        void retornar_saida(double linha[]);
        void ajustar_pesos_neuronios(double erros[], double entrada[]);
        void calcular_erro_camada_saida(double erros[], double Y[]);
        void calcular_erro_camada(double erros[]);
        void calcular_erro_final(double erros[], double Y[]);
        double somatorio_erro(double erros[]);
};

// Inicializa o Numero de Neuronios e o Numero de Pesos
// e invoca a inicialização dos neurônios
void Camada::inicializar(int numero_neuronios, int numero_pesos)
{
    this->numero_neuronios = numero_neuronios;
    this->numero_pesos = numero_pesos;

    for(int i = 0; i < numero_neuronios; i++)
        N[i].inicializar(numero_pesos);
}

// Calcula os erros da camada de saída com base na saída
// desejada Y, retornando os erros
void Camada::calcular_erro_final(double erros[], double Y[])
{
    for(int i = 0; i < this->numero_neuronios; i++)
        erros[i] = Y[i] - saida[i];
}

// Dispara o somatório de um neurônio para uma certa entrada
// armazenando a sua saída
void Camada::treinar_neuronios(double entrada[])
{
    for(int i = 0; i < numero_neuronios; i++)
        saida[i] = N[i].somatorio(entrada);
}

// Calcula os erros da camada de saída com base na saída
// desejada Y, retornando os erros
void Camada::calcular_erro_camada_saida(double erros[], double Y[])
{
    for(int i = 0; i < this->numero_neuronios; i++)
        erros[i] = (Y[i] - this->saida[i]) * this->saida[i] * (1 - this->saida[i]);
}

// Calcula os erros da camada escondida com base no erro
// da camada da frente, retornando os erros
void Camada::calcular_erro_camada(double erros[])
{
    for(int i = 0; i < this->numero_neuronios; i++)
        erros[i] = this->saida[i] * (1 - this->saida[i]) * erros[i];
}

// Ajusta os pesos dos neurônios da camada de acordo com os
// erros da camada da frente, e retorna o somárório de erros
// da própria camada
void Camada::ajustar_pesos_neuronios(double erros[], double entrada[])
{
    int i, j;
    double temp, erro_aux[MAXNEU];

    /* Cálculo do Somatório que será usado para o cálculo do erro
       da camada anterior */

    for (i = 1; i < this->numero_pesos; i++) {
        temp = 0;
        for (j = 0; j < this->numero_neuronios; j++) {
            temp += N[j].erro_peso(erros[j], i);
        }
        erro_aux[i-1] = temp;
    }

    /* Ajusta os pesos de cada neurônio  de acordo com o erro
       da camada da frente e a saída da própria camada */

    for (i = 0; i < this->numero_neuronios; i++)
        for (j = 0; j < this->numero_pesos; j++)
            N[i].ajustar_peso(entrada[j], erros[i],j);

    /* Atribui o vetor de erros calculado, para o vetor erro
       que será retornado */

    for (i = 0; i < this->numero_pesos - 1; i++)
        erros[i] = erro_aux[i];
}

// Atualiza a saída da camada passando-a por uma função
// de ativação
void Camada::funcao_ativacao()
{
    for (int i = 0; i < this->numero_neuronios; i++)
        this->saida[i] = 1/(1 + exp(- this->saida[i]));
}

// Retorna a Saída da Camada
void Camada::retornar_saida(double linha[])
{
    linha[0] = 1;
    for(int i = 1; i <= this->numero_neuronios; i++)
        linha[i] = this->saida[i-1];
}

//*********************** REDE ******************************/

// Struct para conter os parametros da rede neural
struct ParametrosRede
{
    // Número de camadas da rede
    int numero_camadas;
    // Número de linhas de entrada
    int numero_linhas;
    // Número de colunas de entrada
    int numero_colunas_entrada;
    // Número de colunas da saída
    int numero_colunas_saida;
    // Número de neurônios em cada camada
    std::vector<int> numero_neuronio_camada;
};

// Classe que representa uma rede neural
class Rede
{
    public:
        void inicializar(ParametrosRede);
        // Treina toda a rede
        void treinar();
        void calcular_resultado(double entrada[], double saida[]);

    private:
        ParametrosRede parametros;
        // Camadas da rede
        Camada C[MAXCAM];
        // Matriz de entrada da rede
        double X[MAXLIN][MAXCOL];
        // Matriz de saída da rede
        double Y[MAXLIN][MAXCOL];
};


// Inicializa todas as variáveis da rede, inclusive a
// leitura das entradas e saídas da rede
void Rede::inicializar(ParametrosRede parametros)
{
    int i,j;
    FILE *entrada, *saida;

    this->parametros = parametros;

    entrada = fopen("X.txt","rb");
    saida = fopen("Y.txt","rb");

    for(i = 0; i < parametros.numero_linhas; i++)
        for(j = 0; j < parametros.numero_colunas_entrada; j++)
            fread(&X[i][j],sizeof(double), 1, entrada);

    for(i = 0; i < parametros.numero_linhas;i++)
        for(j = 0; j < parametros.numero_colunas_saida; j++)
            fread(&Y[i][j],sizeof(double), 1, saida);

    fclose(entrada);
    fclose(saida);

    C[0].inicializar(parametros.numero_neuronio_camada[0], parametros.numero_colunas_entrada);

    for(i = 1; i < parametros.numero_camadas; i++)
        C[i].inicializar(parametros.numero_neuronio_camada[i], parametros.numero_neuronio_camada[i - 1] + 1);
}

// Calcula a resposta da rede para uma certa entrada,
// retornando a saída
void Rede::calcular_resultado(double entrada[], double saida[])
{
    int i, j;

    for (i = 0; i < this->parametros.numero_camadas; i++) {
        C[i].treinar_neuronios(entrada);
        C[i].funcao_ativacao();
        C[i].retornar_saida(saida);

        for (j = 0; j < MAXNEU; j++)
            entrada[j] = saida[j];
    }
}

// Algoritmmo de Treinamento Back Propagation
void Rede::treinar()
{
    int i, j, linha_escolhida, iteracoes, camada_saida;
    double vetor_saida[MAXNEU], erros[MAXNEU], somatorio_erro, maior;
    long contador, dinamico;
    char sair;

    //Setando todos os valores do array para zero
    int marcados[MAXLIN] = {0};

    dinamico = 0;
    sair = 0;
    contador = 0;
    maior = 1;
    iteracoes = 0;
    camada_saida = this->parametros.numero_camadas - 1;

    do {
        linha_escolhida = rand() % NUMLIN;

        j = 0;
        while (marcados[linha_escolhida] == 1) {
            linha_escolhida++;
            j++;

            if(linha_escolhida == NUMLIN)
                linha_escolhida = 0;

            if(j == NUMLIN)
                std::fill(marcados, marcados + MAXLIN, 0);
        }

        marcados[linha_escolhida] = 1;
        contador++;

        // FEED-FORWARD
        C[0].treinar_neuronios(X[linha_escolhida]);
        C[0].funcao_ativacao();
        C[0].retornar_saida(vetor_saida);

        for (i = 1; i < this->parametros.numero_camadas; i++) {
            C[i].treinar_neuronios(vetor_saida);
            C[i].funcao_ativacao();
            C[i].retornar_saida(vetor_saida);
        }

        // BACK-PROPAGATION

        // Ajustando pesos da camada de saída
        C[camada_saida].calcular_erro_camada_saida(erros, Y[linha_escolhida]);
        C[camada_saida - 1].retornar_saida(vetor_saida);
        C[camada_saida].ajustar_pesos_neuronios(erros, vetor_saida);

        // Ajustando pesos das camadas intermediárias
        for (i = camada_saida - 1; i > 0; i--) {
            C[i].calcular_erro_camada(erros);
            C[i-1].retornar_saida(vetor_saida);
            C[i].ajustar_pesos_neuronios(erros, X[linha_escolhida]);
        }

        // Ajustando pesos da primeira camada
        C[0].calcular_erro_camada(erros);
        C[0].ajustar_pesos_neuronios(erros, X[linha_escolhida]);

        // Calculando o erro global
        C[camada_saida].calcular_erro_final(erros, Y[linha_escolhida]);

        somatorio_erro = 0;
        for (i = 0; i < this->parametros.numero_colunas_saida; i++)
            somatorio_erro += std::pow(erros[i], 2);

        somatorio_erro /= 2;

        // Verificando condições
        if (somatorio_erro < maior) {
            dinamico = 0;
            //gotoxy(1,10);
            std::cout << "\n\nErro = " << somatorio_erro << "   ";
            maior = somatorio_erro;
        } else dinamico++;

        iteracoes = somatorio_erro <= TOLERANCIA ? iteracoes + 1 : 0;

        // Beta dinâmico
        if (dinamico == 200000) {
            dinamico = 0;
            BETA += (rand() % 6 / 10.0) * (rand() % 3 - 1);
        }

        if (dinamico == 50000) BETA = MI;

        // Exibição na tela
        if (contador % 10000 == 0) {
            //gotoxy(1,10);
            std::cout << "\nIteracoes = " << contador;
            std::cout << "\n\nBeta = " << BETA << "  ";
        }

    } while(iteracoes < NUMITE || contador % 100000 != 0);
}

//****************** PROGRAMA PRINCIPAL *****************************/
int main()
{
    // Número de camadas da rede
    int numero_camadas;
    // Número de linhas de entrada
    int numero_linhas = NUMLIN;
    // Número de colunas de entrada
    int numero_colunas_entrada = NUMCOLENT;
    // Número de colunas da saída
    int numero_colunas_saida = NUMCOLSAI;

    std::vector<int> numero_neuronio_camada = std::vector<int>(MAXCAM, 0);
    int i;

    double entrada[MAXNEU];
    double saida[MAXNEU];

    char continua = 'r';
    Rede R;

    while (continua != 'n') {
        if (continua == 'r') {
            std::cout << "\n\nDigite o numero de camadas: ";
            std::cin >> numero_camadas;

            for (i = 0; i < numero_camadas; i++) {
                std::cout << "\n\nDigite o numero de neuronios da camada " << i << " : ";
                std::cin >> numero_neuronio_camada[i];
            }

            ParametrosRede p = ParametrosRede {
                numero_camadas,
                numero_linhas,
                numero_colunas_entrada,
                numero_colunas_saida,
                numero_neuronio_camada
            };

            R.inicializar(p);
            R.treinar();
        }

        std::cout << "\n\nDigite as entradas da rede:\n";

        for (i = 0; i < numero_colunas_entrada; i++) {
            std::cout << "\nEntrada " << i << " : ";
            std::cin >> entrada[i];
        }

        R.calcular_resultado(entrada, saida);

        for (i = 1; i <= numero_colunas_saida; i++)
            std::cout << "\nSaida " << i << " : " << saida[i];

        std::cout << "\n\nContinua ? (s/n/r)";
        std::cin >> continua;
    }
}
