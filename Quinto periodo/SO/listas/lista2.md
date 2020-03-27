# Lista 02 da disciplina de Sistemas Operacionais

1. Considere o seguinte código:

    ```go
    n: integer;
    s, delay : semaforo; // binário

    produtor {
        loop {
           1: wait(s);
           2: critico1;
           3: n = n + 1;
           4: if (n = 1) then 5: signal(delay);
           6: signal(s);
        }
    }
    consumidor {
        7: wait(delay);
        loop {
            8: wait(s);
            9: critico2;
            10: n = n - 1;
            11: if(n = 0) then 12: wait(delay);
            13: signal(s);
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

        - **R:** Tem um problema na solução apresentada acima.<br>
          Ocorre um deadlock quando executado na seguinte sequencia de execução:

            - 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1

            O consumidor quando n &equals; 0 e delay &equals; 0, ele dá um wait(delay)
            suspendendo seu processo, mas não libera o semaforo S para que o produtor
            possa produzir, pois foi suspenso.

2. Cite as condições necessárias para ocorrencia de _deadlock_.
   Descreva cada uma em detalhe.

    - **R:** As seguintes condições são necessarias, mas não garantem a existencia de _deadlock_.
        - **Exclusão mútua:**
          Se um processo usa um recurso, o outro processo deve esperar
          o primeiro terminar.
        - **Posse e espera:** Um processo, que está de posse de ao menos um
          recurso, espera por outros recursos que já estão sendo usados por
          outros processos.
        - **Não preempção:** Um recurso só pode ser liberado pelo processo
          que o utiliza, após terminar sua tarefa.
        - **Espera circular:** Existe um conjunto de processos {A, B, C, D}
          e '&rarr;' demostra uma relação de dependencia de recursos mantidos por outros processos.<br>
          A &rarr; B &rarr; C &rarr; D &rarr; A

3. Um computador tem 6 fitas, com N processos competindo pelas mesmas.
   Cada processo necessita de 2 fitas. Para quais valores de N o sistema
   é livre de _deadlocks_?

    - **R:** Para N &lt; Número de fitas, o sistema é livre de _deadlocks_, nos demais vai ocorrer
      uma espera circular, assim garantindo as 4 condições necessarias para existência de _deadlocks_.

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
    uma unidade de disco. A situação leva a um impasse (_deadlock_)? Por quê?

    - **R:** Sim, pois B requisita uma unidade de impressão que o processo D faz uso,
      e o processo D requisita uma unidade de disco que B já tem posse, esta
      é por sua vez uma espera circular.
