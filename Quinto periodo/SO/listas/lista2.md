# Lista 02 da disciplina de Sistemas Operacionais

1. Considere o seguinte código:

    ```go
    n: integer;
    s, delay : semaforo; // binário

    produtor {
        loop {
            wait(s);
            critico1;
            n = n + 1;
            if (n = 1) then signal(delay);
            signal(s);
        }
    }
    consumidor {
        wait(delay);
        loop {
            wait(s);
            critico2;
            n = n - 1;
            if(n = 0) then wait(delay);
            signal(s);
        }
    }

    begin
        n = 0;
        s = 1;
        delay = 0;
        cobegin
            produtor;
            consumidor;
        coend
    end
    ```

    - Discuta a correção da solução apresentada.
        - **R:**

2. Cite as condições necessárias para ocorrencia de deadlock.
   Descreva cada uma em detalhe.

    - **R:**

3. Um computador tem 6 fitas, com N processos competindo pelas mesmas.
   Cada processo necessita de 2 fitas. Para quais valores de N o sistema
   é livre de deadlocks?

    - **R:**

4. Considere a situação em que 4 processos A, B, C, D concorrem por recursos
   da maquina onde existem 2 unidades de fita, 2 unidades de disco e uma
   unidade de impressão. os processos se encontram na seguinte situação:

    1. O processo A está de posse de uma unidade de fita e requisita uma
       unidade de disco;
    2. O processo B está de posse de uma das unidades de disco;
    3. O processo C está de posse de outra unidade de disco e requisita uma
       unidade de fita;
    4. O processo D está de posse da outra unidade de fita;

    O processo D requisita a unidade de impressão, toma posse do recurso.
    Logo após o processo B faz a mesma requisição. Em seguida D requisita
    uma unidade de disco. A situação leva a um impasse (deadlock)? Por quê?

    - **R:**
