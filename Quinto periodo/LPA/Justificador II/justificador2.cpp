// https://www.urionlinejudge.com.br/judge/pt/problems/view/1278
#include <iostream>
#include <vector>
#include <list>
#include <cmath>
#include <climits>
using namespace std;

const string WHITESPACE = " \n\r\t\f\v";

string left_trim(const string &s)
{
    // http://www.cplusplus.com/reference/string/string/find_first_not_of/
    int start = s.find_first_not_of(WHITESPACE);
    // http://www.cplusplus.com/reference/string/string/npos/
    return start == string::npos ? "" : s.substr(start);
}

string right_trim(const string &s)
{
    // http://www.cplusplus.com/reference/string/string/find_last_not_of/
    int end = s.find_last_not_of(WHITESPACE);
    // http://www.cplusplus.com/reference/string/string/npos/
    return end == string::npos ? "" : s.substr(0, end + 1);
}

string trim(const string &s)
{
    return left_trim(right_trim(s));
}

int main()
{
    int n = 0;

    do
    {
        // Ler o número de linhas de texto a ser lido
        cin >> n;
        cin.ignore();
        vector<string> linhas;

        for (int i = 0; i < n; i++)
        {
            string s = "";
            getline(cin, s);
            s = trim(s);
            int idx_begin_space = 0;
            int idx_end_space = 0;
            for (int i = 0; i < s.length(); i++)
            {
                if (std::isspace(s.at(i)))
                {
                    idx_begin_space = i;
                    idx_end_space = i + 1;
                    while (std::isspace(s.at(idx_end_space)))
                    {
                        idx_end_space++;
                    }
                    s.erase(idx_begin_space, idx_end_space - idx_begin_space - 1);
                }
            }
            linhas.push_back(s);
        }

        int maior_length = 0;
        // Obtendo o tamanho da maior string
        for (auto &s : linhas)
        {
            if (s.length() > maior_length)
                maior_length = s.length();
        }

        for (auto &s : linhas)
        {
            if (s.length() < maior_length)
            {
                // Adicionando espacos no inicio da string para
                // justificar de acordo com a string de maior tamanho
                int spacos = maior_length - s.length();
                s.insert(0, spacos, ' ');
            }
            cout << s << endl;
        }
    } while (n > 0);

    return 0;
}