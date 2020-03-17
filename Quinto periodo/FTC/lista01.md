## Lista 01 de Fundamentos Teóricos da Computação

1. Dê a definição recursiva do conjunto de strings sobre o alfabeto {a, b} que contenha um número par de b´s.
   - **R:**
     ```tex
      Σ={a,b} Par(b)
      Caso Base: λ ϵ Par(b)
      Passo Recursivo:
         Se w ϵ Par(b), então
         aw ϵ Par(b) e wa ϵ Par(b)
         bbw ϵ Par(b), bwb ϵ Par(b), wbb ϵ Par(b)
     ```

2. Mostre que:
   - a) `(b.a)+ (a*.b* U a*) = (b.a)* b.a+ (b* U λ)`
   - b) `b+ (a*.b* U λ) b  =  b (b*.a* U λ) b+`
     - **R:**
       ```tex
         b+ (a*.b* U λ) b
         b.b* (a*.b* U λ) b
         b (b*.a*.b* U λ.b*) b
         b (b*.a* U λ) b*.b
         b (b*.a* U λ) b+
       ```

3. Forneça as expressões regulares para o conjunto de strings sobre:
   - a) Σ = {a, b} de tamanho >= 2, no qual todos os a’s precedem todos os b’s.
   - b) Σ = {a, b} que contém o substring aa.
   - c) Σ = {a, b} que possui exatamente um par aa.
     - **R:** `(b U a.b)* a.a (b U b.a)*`
   - d) Σ = {a, b, c} que começa com a, contém exatamente dois b’s e termina com cc.
   - e) Σ = {a, b} que contém o substring  ab  e  o substring ba.
   - f) Σ = {a, b, c} que contém o substring aa, bb e cc.
   - g) Σ = {a, b, c} no qual cada b é imediatamente seguido por pelo menos um c.
   - h) Σ = {a, b, c} de tamanho 3.
   - i) Σ = {a, b, c} com tamanho menor que 3.
   - j) Σ = {a, b, c} com tamanho maior que 3.
   - k) Σ = {a, b} com um número par de a’s e impar de b´s.

4. Nos seguintes exercícios, construa AFD’s segundo os enunciados.
   - a) O conjunto de strings sobre Σ = {a, b} que não contém o substring aaa.
   - b) O conjunto de strings sobre Σ = {a, b, c} que começa com a, tem exatamente dois b’s e termina com exatamente cc.

5. Para cada uma das linguagens abaixo, dê um λ-AFN correspondente:
    - a) `(ab)*ba`
    - b) `(ab)*(ba)*`
    - c) `(ab)*ba ∪ (ab)*(ba)*`
    - d) `(aa(a ∪ b)+bb)*`

6. Para cada um dos autômatos acima gere o AFD equivalente.

7. As seguintes linguagens são regulares? Prove.
   - a) `{ 0^n 1^m  |  m, n  ≥ 0 }`
   - b) `{ 0^n 1^m 0^n  |  m, n  ≥ 0 }`
