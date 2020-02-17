#include <iostream>
#include <vector>
#include <list>
#include <cmath>
#include <climits>
using namespace std;

// Estrutura criada para poder retornar
// 3 valores da função max_sum_array
struct ResultKadane
{
    // Representa o resultado da soma
    int max_sum;
    // Representa o indice inicial do subarray
    int idx_max_cbegin;
    // Representa o indice final do subarray
    int idx_max_cend;

    ResultKadane(int mx, int idx_begin, int idx_end)
    {
        max_sum = mx;
        idx_max_cbegin = idx_begin;
        idx_max_cend = idx_end;
    }
};

// Implementação do algoritmo de Kadane
// "Maximum contiguous subarray sum"
// Para compreender: https://www.youtube.com/watch?v=2MmGzdiKR9Y
ResultKadane max_sum_array(vector<int> &array)
{
    int idx_max_cbegin = 0;
    int idx_max_cend;

    int size = array.size();
    vector<int> temp(size, 0);

    temp.at(0) = array.at(0);
    for (int i = 1; i < size; i++)
    {
        // Dedução:
        // Se o valor na posição i do array for maior do que a soma dele
        // com o sub array que já temos, é melhor começar um novo subarray com
        // esse valor, do que "sofrer" com um valor menor.
        if (array.at(i) > array.at(i) + temp.at(i - 1))
        {
            idx_max_cbegin = i;
            idx_max_cend = i;
            temp.at(i) = array.at(i);
        }
        else
        {
            idx_max_cend = i;
            temp.at(i) = array.at(i) + temp.at(i - 1);
        }
    }

    // Apos a dedução acima, verificamos se existe um sub array continuo
    // interno cuja soma foi maior do que o final acima
    int max_sum = INT_MIN;
    int new_idx_cend;
    for (int i = idx_max_cbegin; i <= idx_max_cend; i++)
    {
        if (temp.at(i) >= max_sum)
        {
            max_sum = temp.at(i);
            new_idx_cend = i;
        }
    }
    idx_max_cend = new_idx_cend;
    return ResultKadane(max_sum, idx_max_cbegin, idx_max_cend);
}

// Algoritmo que encontra o "Maximum sum rectangle"
// Usando como base o Kadane, no lugar de brute-force
// Para melhor compreensão do funcionamento
// veja o video: https://www.youtube.com/watch?v=-FgseNO-6Gk
int max_sum_matriz(vector<vector<int>> &matriz)
{
    int size_col = matriz.size();
    int size_row = matriz.at(0).size();

    // O valor da soma da sub-matriz de maior soma
    int max_retangle_sum = 0;

    // indices de localização da sub-matriz de maior soma
    int max_retangle_left = -1;
    int max_retangle_right = -1;
    int max_retangle_top = -1;
    int max_retangle_bottom = -1;

    // Quando o for interno termina, avançamos no lado esquerdo
    // da matriz
    for (int left = 0; left < size_col; left++)
    {
        // Array que representa a somas de cada linha da sub-matriz
        // conforme a posição left e right
        vector<int> rows_sum_array(size_row, 0);
        // Aqui ocorre uma expansão para a direita na matriz
        for (int right = left; right < size_col; right++)
        {
            for (int i = 0; i < size_row; i++)
            {
                rows_sum_array.at(i) += matriz.at(right).at(i);
            }
            // Usamos o algoritmo de kadane para definir o top e
            // bottom do nosso retangulo, alem da soma final
            ResultKadane rk = max_sum_array(rows_sum_array);
            if (rk.max_sum > max_retangle_sum)
            {
                max_retangle_sum = rk.max_sum;
                // Esses valores podem ser usados posteriormente
                // para identificar a localização do retangulo de
                // maior soma.
                max_retangle_left = left;
                max_retangle_right = right;
                max_retangle_top = rk.idx_max_cbegin;
                max_retangle_bottom = rk.idx_max_cend;
            }
        }
    }
    return max_retangle_sum;
}

void show_matriz(vector<vector<int>> &matriz)
{
    for (auto linha : matriz)
    {
        for (auto v : linha)
        {
            if (v >= 0)
                std::cout << " " << v << " ";
            else
                std::cout << v << " ";
        }
        std::cout << endl;
    }
}

int main()
{
    int size;

    // Leitura do tamanho da matriz
    cin >> size;

    // Criação da matriz quadrada
    vector<vector<int>> matriz(size, vector<int>(size, 0));

    // escrevendo os valores na matriz
    for (auto &linha : matriz)
    {
        for (auto &v : linha)
        {
            cin >> v;
        }
    }

    std::cout << max_sum_matriz(matriz) << endl;

    return 0;
}
