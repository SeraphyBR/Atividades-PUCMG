#!/bin/bash
#Compilando os programas
echo "Compilando os programas...";
gcc countingSortNaoParalelo.c -o countingSortNaoParalelo.exe;
gcc countingSortParalelo.c -o countingSortParalelo.exe -fopenmp;

#Executando testes
#Teste velocidade
read -p 'Deseja testar a velociadade de execucao do programa? ' testeVelociade;
if [ "$testeVelociade" == "sim" ]
then
echo "Testando a velociade de execucao do programa: ";
echo "Tempo de execucao do CountingSort Não Paralelo:";
time ./countingSortNaoParalelo.exe <in1milhao.txt >saidaNaoParalelo.txt;
echo "Tempo de execucao do CountingSort Paralelo:";
time ./countingSortParalelo.exe <in1milhao.txt >saidaParalelo.txt;
fi
read -p 'Deseva comparar os dados da saida? ' testeSaida;
if [ "$testeSaida" == "sim" ]
then
echo "Mostrando a comparação das saidas";
./countingSortNaoParalelo.exe <in1milhao.txt >saidaNaoParalelo.txt;
./countingSortParalelo.exe <in1milhao.txt >saidaParalelo.txt;
vimdiff saidaNaoParalelo.txt saidaParalelo.txt;
fi
echo "Fim dos testes";
echo "Apagando os arquivos inuteis..."
rm countingSortParalelo.exe;
rm countingSortNaoParalelo.exe;
rm saidaParalelo.txt;
rm saidaNaoParalelo.txt;
