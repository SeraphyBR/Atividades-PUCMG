
// Autor: Luiz Junio Veloso Dos Santos

#include <stdio.h>
#include <stdlib.h>
#include <string.h>



//##############################################################################
/*
 * Descreve uma Instituicao de Ensino Superior (IES)
 */
typedef struct Instituicao{
    int codigo;
    char nome[200];
    char sigla[20];
    int codigoMantenedora;
    char mantenedora[200];
    int categoria;
    int organizacao;
    int codigoMunicio;
    char municipio[150];
    char uf[2];
    char regiao[20];
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
    strncpy(new->nome, nome, 200);
    strncpy(new->sigla, sigla, 20);
    new->codigoMantenedora = 0;
    strcpy(new->mantenedora, "");
    new->categoria = 0;
    new->organizacao = 0;
    new->codigoMunicio = 0;
    strcpy(new->municipio, "");
    strcpy(new->uf, "");
    strcpy(new->regiao, "");
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

//##############################################################################
