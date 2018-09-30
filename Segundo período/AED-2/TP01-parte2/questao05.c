
// Autor: Luiz Junio Veloso Dos Santos

#include <bsd/string.h>
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
    char* temp = strtok(string, " ");
    char* valor[24];
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
}//Fim strToInstituicao

//##############################################################################
