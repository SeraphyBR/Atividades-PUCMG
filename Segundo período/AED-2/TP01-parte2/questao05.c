
// Autor: Luiz Junio Veloso Dos Santos

#include <bsd/string.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>

#define TAM_NOME 200
#define TAM_SIGLA 20
#define TAM_MANTENEDORA 200
#define TAM_MUNICIPIO 150
#define TAM_UF 2
#define TAM_REGIAO 20

//##############################################################################
/*
 * Descreve uma Instituicao de Ensino Superior (IES)
 * @author Luiz Junio Veloso Dos Santos
 * @version 1.0
 */
typedef struct Instituicao{
    int codigo;
    char nome[TAM_NOME + 1];
    char sigla[TAM_SIGLA + 1];
    int codigoMantenedora;
    char mantenedora[TAM_MANTENEDORA + 1];
    int categoria;
    int organizacao;
    int codigoMunicio;
    char municipio[TAM_MUNICIPIO + 1];
    char uf[TAM_UF + 1];
    char regiao[TAM_REGIAO + 1];
    int tecnico;
    int periodico;
    int livro;
    double receita;
    double transferencia;
    double outraReceita;
    double despesaDocente;
    double despesaTecnico;
    double despesaEncargo;
    double despesaCusteio;
    double despesaInvestimento;
    double despesaPesquisa;
    double despesaOutras; 
} Instituicao;


Instituicao* newInstituicao(int codigo, char* nome, char* sigla)
{//Inicio newIntituicao
    Instituicao* new = (Instituicao*) malloc(sizeof(Instituicao));
    new->codigo = codigo;
    strlcpy(new->nome, nome, TAM_NOME + 1);
    strlcpy(new->sigla, sigla, TAM_SIGLA + 1);
    new->codigoMantenedora = 0;
    strlcpy(new->mantenedora, "", TAM_MANTENEDORA + 1);
    new->categoria = 0;
    new->organizacao = 0;
    new->codigoMunicio = 0;
    strlcpy(new->municipio, "", TAM_MUNICIPIO + 1);
    strlcpy(new->uf, "", TAM_UF + 1);
    strlcpy(new->regiao, "", TAM_REGIAO + 1);
    new->tecnico = 0;
    new->periodico = 0;
    new->livro = 0;
    new->receita = 0.0;
    new->transferencia = 0.0;
    new->outraReceita = 0.0;
    new->despesaDocente = 0.0;
    new->despesaTecnico = 0.0;
    new->despesaEncargo = 0.0;
    new->despesaCusteio = 0.0;
    new->despesaInvestimento = 0.0;
    new->despesaPesquisa = 0.0;
    new->despesaOutras = 0.0;
    return new;
}//Fim newInstituicao

Instituicao* newInstituicaoVazio(){
    return newInstituicao(0, "", "");
} 

Instituicao* cloneInstituicao( Instituicao* i )
{//Inicio cloneInstituicao
    Instituicao* clone = (Instituicao*) malloc(sizeof(Instituicao));      
    clone->codigo = i->codigo;
    strlcpy(clone->nome, i->nome, TAM_NOME + 1);
    strlcpy(clone->sigla, i->sigla, TAM_SIGLA + 1);
    clone->codigoMantenedora = i->codigoMantenedora;
    strlcpy(clone->mantenedora, i->mantenedora, TAM_MANTENEDORA + 1);
    clone->categoria = i->categoria;
    clone->organizacao = i->organizacao;
    clone->codigoMunicio = i->codigoMunicio;
    strlcpy(clone->municipio, i->municipio, TAM_MUNICIPIO + 1);
    strlcpy(clone->uf, i->uf, TAM_UF + 1);
    strlcpy(clone->regiao, i->regiao, TAM_REGIAO + 1);
    clone->tecnico = i->tecnico;
    clone->periodico = i->periodico;
    clone->livro = i->livro;
    clone->receita = i->receita;
    clone->transferencia = i->transferencia;
    clone->outraReceita = i->outraReceita;
    clone->despesaDocente = i->despesaDocente;
    clone->despesaTecnico = i->despesaTecnico;
    clone->despesaEncargo = i->despesaEncargo;
    clone->despesaCusteio = i->despesaCusteio;
    clone->despesaInvestimento = i->despesaInvestimento;
    clone->despesaPesquisa = i->despesaPesquisa;
    clone->despesaOutras = i->despesaOutras;  
    return clone; 
}//Fim cloneInstituicao

Instituicao* strToInstituicao(char* string)
{//Inicio strToInstituicao
    Instituicao* new = (Instituicao*) malloc(sizeof(Instituicao));

    int i = 0;
    char* temp = strtok(string, "\t");
    char** valor = (char**) malloc(sizeof(char*) * 24);
    while(temp != NULL && i < 24){
        valor[i++] = temp;
        temp = strtok(NULL, " ");
    }
     
    new->codigo = atoi(valor[0]);
    strlcpy(new->nome, valor[1], TAM_NOME + 1);
    strlcpy(new->sigla, valor[2], TAM_SIGLA + 1);
    new->codigoMantenedora = atoi(valor[3]);
    strlcpy(new->mantenedora, valor[4], TAM_MANTENEDORA + 1);
    new->categoria = atoi(valor[5]);
    new->organizacao = atoi(valor[6]);
    new->codigoMunicio = atoi(valor[7]);
    strlcpy(new->municipio, valor[8], TAM_MUNICIPIO + 1);
    strlcpy(new->uf, valor[9], TAM_UF + 1);
    strlcpy(new->regiao, valor[10], TAM_REGIAO + 1);
    new->tecnico = atoi(valor[11]);
    new->periodico = atoi(valor[12]);
    new->livro = atoi(valor[13]);
    new->receita = atof(valor[14]);
    new->transferencia = atof(valor[15]);
    new->outraReceita = atof(valor[16]);
    new->despesaDocente = atof(valor[17]);
    new->despesaTecnico = atof(valor[18]);
    new->despesaEncargo = atof(valor[19]);
    new->despesaCusteio = atof(valor[20]);
    new->despesaInvestimento = atof(valor[21]);
    new->despesaPesquisa = atof(valor[22]);
    new->despesaOutras = atof(valor[23]);                
    return new;
}//Fim strToInstituicao

void imprime( Instituicao* i )
{//Inicio imprime
    printf("%d %s %s %d %s %d %d %d %s %s %s %d %d %d %lf %lf %lf %lf %lf %lf %lf %lf %lf %lf\n",
          i->codigo, i->nome, i->sigla, i->codigoMantenedora, i->mantenedora, i->categoria,
          i->organizacao, i->codigoMunicio, i->municipio, i->uf, i->regiao, i->tecnico,
          i->periodico, i->livro, i->receita, i->transferencia, i->outraReceita, 
          i->despesaDocente, i->despesaTecnico, i->despesaEncargo, i->despesaCusteio,
          i->despesaInvestimento, i->despesaPesquisa, i->despesaOutras 
          );
}//Fim imprime

//##############################################################################

/*
 * Lista estatica de Instituicao
 */
typedef struct Lista{
   int tamArray;
   int numElementos;
   Instituicao** array;
} Lista;

/*
 * Cria uma nova lista de tamanho N
 * e retorna seu endereco
 */
Lista* newListaN(int tamanho)
{//Inicio newListaN
    Lista* lista = (Lista*) malloc(sizeof(Lista));
    lista->array = (Instituicao**) malloc(sizeof(Instituicao*) * tamanho);
    lista->tamArray = tamanho;
    lista->numElementos = 0;
    return lista;
}//Fim newListaN

/*
 * Cria uma nova lista de tamanho 5
 */
Lista* newLista(){
    return newListaN(5);
}

/*
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da lista.
 */
void inserirInicio(Lista* l, Instituicao* i)
{//Inicio inserirInicio
    if(l != NULL && i != NULL)
    {//Inicio if
        if(l->numElementos >= l->tamArray){
            printf("Erro ao inserir!");
            exit(EXIT_FAILURE);
        }
        else{
            for(int i = l->numElementos; i > 0; i--){
                l->array[i] = l->array[i - 1];
            }
            l->array[0] = i;
            l->numElementos++;
        }
    }//Fim if
    else{
        printf("Parametros invalidos!");
    }
}//Fim inserirInicio

void inserirFim(Lista* l, Instituicao* i)
{//Inicio inserirFim

}//Fim inserirFim

//##############################################################################
