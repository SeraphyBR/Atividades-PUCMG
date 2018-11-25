
// Autor: Luiz Junio Veloso Dos Santos

#define _GNU_SOURCE
#include <err.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TAM_NOME 200
#define TAM_SIGLA 20
#define TAM_MANTENEDORA 200
#define TAM_MUNICIPIO 150
#define TAM_UF 2
#define TAM_REGIAO 20
#define MAX_TAM_LINE 3000
#define MAX_NUM_LINES 3000

// ##############################################################################
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
    strncpy(new->nome, nome, TAM_NOME + 1);
    strncpy(new->sigla, sigla, TAM_SIGLA + 1);
    new->codigoMantenedora = 0;
    strncpy(new->mantenedora, "", TAM_MANTENEDORA + 1);
    new->categoria = 0;
    new->organizacao = 0;
    new->codigoMunicio = 0;
    strncpy(new->municipio, "", TAM_MUNICIPIO + 1);
    strncpy(new->uf, "", TAM_UF + 1);
    strncpy(new->regiao, "", TAM_REGIAO + 1);
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
    strncpy(clone->nome, i->nome, TAM_NOME + 1);
    strncpy(clone->sigla, i->sigla, TAM_SIGLA + 1);
    clone->codigoMantenedora = i->codigoMantenedora;
    strncpy(clone->mantenedora, i->mantenedora, TAM_MANTENEDORA + 1);
    clone->categoria = i->categoria;
    clone->organizacao = i->organizacao;
    clone->codigoMunicio = i->codigoMunicio;
    strncpy(clone->municipio, i->municipio, TAM_MUNICIPIO + 1);
    strncpy(clone->uf, i->uf, TAM_UF + 1);
    strncpy(clone->regiao, i->regiao, TAM_REGIAO + 1);
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
    char *saveptr;
    char *temp = strtok_r(string, "\t", &saveptr);
    char *valor[24];
    while(temp != NULL && i < 24){
        valor[i] = malloc(sizeof(char) * 201);
        strncpy(valor[i++], temp, 201);
        temp = strtok_r(NULL,"\t", &saveptr);
    }
    free(saveptr);

    new->codigo = atoi(valor[0]);
    strncpy(new->nome, valor[1], TAM_NOME + 1);
    strncpy(new->sigla, valor[2], TAM_SIGLA + 1);
    new->codigoMantenedora = atoi(valor[3]);
    strncpy(new->mantenedora, valor[4], TAM_MANTENEDORA + 1);
    new->categoria = atoi(valor[5]);
    new->organizacao = atoi(valor[6]);
    new->codigoMunicio = atoi(valor[7]);
    strncpy(new->municipio, valor[8], TAM_MUNICIPIO + 1);
    strncpy(new->uf, valor[9], TAM_UF + 1);
    strncpy(new->regiao, valor[10], TAM_REGIAO + 1);
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
    if(i != NULL){
        printf("%d %s %s %d %s %d %d %d %s %s %s %d %d %d %lf %lf %lf %lf %lf %lf %lf %lf %lf %lf\n",
            i->codigo, i->nome, i->sigla, i->codigoMantenedora, i->mantenedora, i->categoria,
            i->organizacao, i->codigoMunicio, i->municipio, i->uf, i->regiao, i->tecnico,
            i->periodico, i->livro, i->receita, i->transferencia, i->outraReceita, 
            i->despesaDocente, i->despesaTecnico, i->despesaEncargo, i->despesaCusteio,
            i->despesaInvestimento, i->despesaPesquisa, i->despesaOutras 
          );
    
    }
}//Fim imprime

//##############################################################################

//TIPO CELULA ===================================================================
typedef struct Celula {
    Instituicao* elemento;        // Elemento inserido na celula.
    struct Celula* prox;          // Aponta a celula prox.
} Celula;

Celula* newCelula(Instituicao* i){
    Celula* new = (Celula*) malloc(sizeof(Celula));
    if(i != NULL){
        new->elemento = cloneInstituicao(i);
    }
    else{
        new->elemento = NULL;
    }
    new->prox = NULL;
    return new;
}

Celula* newCelulaVazia(){
    return newCelula(NULL);
}
//PILHA PROPRIAMENTE DITA =======================================================

typedef struct PilhaDinamica{
    Celula* topo;
    int numElementos;
} PilhaDinamica;


/**
 * Cria uma pilha sem elementos.
 */
PilhaDinamica* newPilhaDinamica(){
    PilhaDinamica* new = (PilhaDinamica*) malloc(sizeof(PilhaDinamica));
    new->topo = NULL;
    new->numElementos = 0;
    return new;
}

void inserir(Instituicao* instituicao, PilhaDinamica* pil){
    if(pil != NULL){
        Celula* tmp = newCelula(instituicao);
        tmp->prox = pil->topo;
        pil->topo = tmp;
        tmp = NULL;
        pil->numElementos++;
    }
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Instituicao* remover(PilhaDinamica* pil){
    Instituicao* removido = NULL;
    if (pil != NULL) {

        if(pil->topo == NULL || pil->numElementos == 0){
            errx(1, "Erro ao remover!");
        }

        removido = pil->topo->elemento;
        Celula* tmp = pil->topo;
        pil->topo = pil->topo->prox;
        tmp->prox = NULL;
        free(tmp);
        pil->numElementos--;
        tmp = NULL;
    }
    return removido;
}


/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrarRec(Celula* i){
    if(i != NULL){
        mostrarRec(i->prox);
        imprime(i->elemento);
    }
}

void mostrar(PilhaDinamica* pil){
    mostrarRec(pil->topo);
}

//##############################################################################

//Funcao principal
int main(){
    int linha[1000];
    int i = 0;

    do{
        scanf("%d", &linha[i]);
    }while(linha[i++] != 0);

    i--;//Desconsiderar ultima linha contendo 0

    FILE *arq = fopen("/tmp/censo.dat", "r+");
    char *registro[MAX_NUM_LINES];
    if(arq != NULL){
        int numEntrada = 0;
        int nread = 0;//Variavel para saber o tamanho da linha lida.
        char *temp = NULL;
        while((nread = getline(&temp, 0, arq)) != -1 && numEntrada < MAX_NUM_LINES){
            registro[numEntrada] = malloc(sizeof(char) * MAX_TAM_LINE);
            strncpy(registro[numEntrada++], temp, nread);
        }
        free(temp);
        fclose(arq);
    } 

    PilhaDinamica *pilha = newPilhaDinamica();
    for(int cont = 0; cont < i; cont++){
        inserir(strToInstituicao(registro[linha[cont]]), pilha);
    }
    
    //Inicio parte 2
    int numAlteracoes = 0;
    scanf("%d", &numAlteracoes);

    char operacao = ' ';
    int linhaArquivo = 0;//Linha do arquivo que contem a instituicao a ser lida.
    Instituicao *removido = NULL;

    for(int cont = 0; cont < numAlteracoes; cont++){
        scanf("%c", &operacao);
        switch(operacao){
            case 'I'://Insercao
                scanf("%d", &linhaArquivo);
                inserir(strToInstituicao(registro[linhaArquivo]), pilha);
                break;
            case 'R'://remocao
                removido = remover(pilha);
                printf("(R) %s", removido->nome);
                break;
        }
    }

    mostrar(pilha);
    free(pilha);
    return 0;
}

