-- Nome: Luiz Junio Veloso Dos Santos
-- Matricula: 624037
DROP DATABASE Biblioteca;
CREATE DATABASE Biblioteca;

USE Biblioteca;

CREATE TABLE IF NOT EXISTS Autor (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome_autor NVARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

CREATE TABLE IF NOT EXISTS Editora (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome_editora NVARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

CREATE TABLE IF NOT EXISTS Assunto (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Descricao NVARCHAR(200) NOT NULL,
    PRIMARY KEY (Codigo)
);

CREATE TABLE IF NOT EXISTS Livro (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Titulo NVARCHAR(40) NOT NULL,
    Ano_pub INTEGER NOT NULL,
    Codigo_editora INTEGER NOT NULL,
    Codigo_assunto INTEGER NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (Codigo_editora) REFERENCES Editora (Codigo),
    FOREIGN KEY (Codigo_assunto) REFERENCES Assunto (Codigo)
);

CREATE TABLE IF NOT EXISTS Autoria (
    Codigo_livro INTEGER NOT NULL,
    Codigo_autor INTEGER NOT NULL,
    PRIMARY KEY (Codigo_livro, Codigo_autor),
    FOREIGN KEY (Codigo_livro) REFERENCES Livro (Codigo),
    FOREIGN KEY (Codigo_autor) REFERENCES Autor (Codigo)
);

CREATE TABLE IF NOT EXISTS Exemplar (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Codigo_livro INTEGER NOT NULL,
    Data_aquisicao DATE NOT NULL,
    Valor_aquisicao FLOAT NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (Codigo_livro) REFERENCES Livro (Codigo)
);

CREATE TABLE IF NOT EXISTS Aluno (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome NVARCHAR(50) NOT NULL,
    Data_nascimento DATE NOT NULL,
    Cidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

CREATE TABLE IF NOT EXISTS Emprestimo (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Data_emprestimo DATE NOT NULL,
    Codigo_aluno INTEGER NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (Codigo_aluno) REFERENCES Aluno (Codigo)
);

CREATE TABLE IF NOT EXISTS Item_emprestado (
    Codigo_emprestimo INTEGER NOT NULL,
    Item INTEGER NOT NULL,
    Codigo_exemplar INTEGER NOT NULL,
    Data_devolucao DATE NOT NULL,
    Multa FLOAT NOT NULL,
    PRIMARY KEY (Codigo_emprestimo, Item),
    FOREIGN KEY (Codigo_emprestimo) REFERENCES Emprestimo (Codigo),
    FOREIGN KEY (Codigo_exemplar) REFERENCES Exemplar (Codigo)
);

-- 2
INSERT INTO Aluno (Nome, Data_nascimento, Cidade)
VALUES ('Luiz Junio', '1999-09-16', 'Belo Horizonte'),
       ('Allan Vivekananda', '1998-03-14', 'Justinópolis'),
       ('Henrique Fernandes', '2000-08-01', 'Belo Horizonte'),
       ('Bernardo Valadares', '1999-10-22', 'São Paulo'),
       ('Daniel Serra', '1999-08-16', 'Uberlandia'),
       ('Thomas Carvalho', '1994-10-16', 'Vitoria');

INSERT INTO Autor (Nome_autor)
VALUES ('Carlos Drummond de Andrade'),
       ('Euclides da Cunha'),
       ('Machado de Assis'),
       ('Mário de Andrade'),
       ('Monteiro Lobato'),
       ('Navathe');

INSERT INTO Editora (Nome_editora)
VALUES ('Pearson'),
       ('Campus'),
       ('Brasilience'),
       ('Makron Books');

INSERT INTO Assunto (Descricao)
VALUES ('Literatura Brasileira'),
        ('Banco de Dados'),
        ('Nenhum');

INSERT INTO Livro (Titulo, Ano_pub, Codigo_editora, Codigo_assunto)
VALUES ('O Sítio do Pica-pau Amarelo', 2005, 3, 1),
       ('Sistemas de Banco de Dados', 2005, 1, 2),
       ('Os Sertões', 2015, 3, 1),
       ('Livro1', 1999, 2, 3),
       ('Livro2', 1998, 2, 3),
       ('Livro3', 1997, 3, 3),
       ('Livro4', 1996, 3, 3),
       ('Livro5', 1995, 4, 3),
       ('Livro6', 1994, 4, 3),
       ('Livro7', 1993, 4, 3),
       ('Livro8', 1992, 4, 3),
       ('Livro9', 1991, 4, 3),
       ('Livro10', 1990, 2, 3);

INSERT INTO Autoria (Codigo_livro, Codigo_autor)
VALUES (1,5),
       (2,6),
       (3,2),
       (3,6),
       (4,6),
       (5,3),
       (5,6),
       (6,6),
       (7,6),
       (5,1),
       (6,1),
       (7,1),
       (8,1),
       (9,1),
       (10,1),
       (11,1),
       (12,1);

INSERT INTO Exemplar (Codigo_livro, Data_aquisicao, Valor_aquisicao)
VALUES (1, '2019-11-24', 8),
       (2, '2019-11-24', 40),
       (3, '2019-11-24', 40),
       (4, '2019-11-24', 40),
       (5, '2019-11-24', 40),
       (6, '2019-11-24', 40),
       (7, '2019-11-24', 40),
       (8, '2019-11-24', 40),
       (9, '2019-11-24', 40),
       (10, '2019-11-24', 40),
       (11, '2019-11-24', 40),
       (12, '2019-11-24', 40),
       (2, '2019-11-24', 40),
       (3, '2019-11-24', 40),
       (4, '2019-11-24', 40),
       (5, '2019-11-24', 40),
       (6, '2019-11-24', 40),
       (7, '2019-11-24', 40),
       (8, '2019-11-24', 140),
       (9, '2019-11-24', 140),
       (10, '2019-11-24', 140),
       (11, '2019-11-24', 140),
       (12, '2019-11-24', 140);

INSERT INTO Emprestimo (Data_emprestimo, Codigo_aluno)
VALUES ('2018-11-24', 4),
       ('2019-11-24', 3),
       ('2019-08-14', 1),
       ('2019-09-13', 1),
       ('2019-09-14', 1),
       ('2019-10-03', 1),
       ('2019-10-10', 1),
       ('2019-08-14', 1),
       ('2019-09-13', 1),
       ('2019-09-14', 1),
       ('2019-10-03', 1),
       ('2019-10-10', 1),
       ('2019-08-14', 2),
       ('2019-09-13', 2),
       ('2019-09-14', 2),
       ('2019-10-03', 2),
       ('2019-10-10', 2),
       ('2019-08-14', 2),
       ('2019-09-13', 2),
       ('2019-09-14', 2),
       ('2019-10-03', 2),
       ('2022-09-21', 2),
       ('2022-09-20', 4);

INSERT INTO Item_emprestado (Codigo_emprestimo, Item, Codigo_exemplar, Data_devolucao, Multa)
VALUES (1, 1, 1, '2018-11-28', 20),
       (2, 1, 2, '2019-11-26', 0),
       (3, 1, 3, '2022-10-22', 150),
       (4, 1, 4, '2022-10-22', 150),
       (5, 1, 5, '2022-10-22', 50),
       (6, 1, 6, '2022-10-22', 50),
       (7, 1, 7, '2022-10-22', 50),
       (8, 1, 8, '2022-10-22', 50),
       (9, 1, 9, '2022-10-22', 50),
       (10, 1, 10, '2022-10-22', 50),
       (11, 1, 11, '2022-10-22', 150),
       (12, 1, 12, '2022-10-22', 50),
       (13, 1, 13, '2022-10-22', 150),
       (14, 1, 14, '2022-10-22', 50),
       (15, 1, 15, '2022-10-22', 150),
       (16, 1, 16, '2022-10-22', 150),
       (17, 1, 17, '2022-10-22', 150),
       (18, 1, 18, '2022-10-22', 150),
       (19, 1, 19, '2022-10-22', 150),
       (20, 1, 20, '2022-10-22', 150),
       (21, 1, 21, '2022-10-22', 150),
       (22, 1, 22, '2022-09-23', 150),
       (23, 1, 23, '2022-09-22', 150);

-- 3
SELECT Livro.Titulo, Livro.Ano_pub, COUNT(Exemplar.Codigo_livro), AVG(Exemplar.Valor_aquisicao)
FROM Livro, Assunto, Exemplar
WHERE YEAR(Data_aquisicao) = 2019
    AND Assunto.Codigo = Livro.Codigo_assunto
    AND Descricao = 'Literatura Brasileira'
    AND Livro.Codigo = Exemplar.Codigo_livro
GROUP BY Livro.Titulo;

-- 4
SELECT Livro.Titulo, Emprestimo.Data_emprestimo, Item_emprestado.Multa
FROM Livro, Item_emprestado, Emprestimo, Exemplar, Aluno
WHERE Aluno.Nome = 'Bernardo Valadares'
    AND Item_emprestado.Codigo_emprestimo = Emprestimo.Codigo
    AND Emprestimo.Codigo_aluno = Aluno.Codigo
    AND Item_emprestado.Codigo_exemplar = Exemplar.Codigo
    AND Livro.Codigo = Exemplar.Codigo_livro;

-- 5
SELECT *
FROM Aluno
EXCEPT
SELECT Aluno.*
FROM Aluno, Emprestimo
WHERE Aluno.Codigo = Emprestimo.Codigo_aluno;

-- 6
SELECT A.Nome, COUNT(E.Codigo)
FROM Aluno as A
LEFT JOIN Emprestimo as E on E.Codigo_aluno = A.Codigo
GROUP BY A.Nome;

-- 7
SELECT Nome_autor
FROM Autor, Autoria, Livro, Assunto
WHERE Autoria.Codigo_autor = Autor.Codigo
    AND Autoria.Codigo_livro = Livro.Codigo
    AND Livro.Codigo_assunto = Assunto.Codigo
    AND Assunto.Descricao = 'Literatura Brasileira';

-- 8
SELECT Nome
FROM Aluno
WHERE (SELECT COUNT(DISTINCT Codigo_livro)
       FROM Emprestimo, Item_emprestado, Exemplar
       WHERE Emprestimo.Codigo_aluno = Aluno.Codigo
            AND YEAR(Data_emprestimo) = 2019
            AND Item_emprestado.Codigo_emprestimo = Emprestimo.Codigo
            AND Item_emprestado.Codigo_exemplar = Exemplar.Codigo) >= 10;

-- 9
SELECT DISTINCT Nome_autor
FROM Autor, Autoria
WHERE Autor.Codigo = Autoria.Codigo_autor
      AND Autor.Nome_autor != 'Navathe'
      AND Autoria.Codigo_livro in
      (SELECT DISTINCT Autoria.Codigo_livro
       FROM Autor, Autoria
        WHERE Autoria.Codigo_autor = Autor.Codigo
        AND Autor.Nome_autor = 'Navathe');

-- 10
SELECT a1.Nome_autor
FROM Autor as a1
WHERE (SELECT COUNT(Livro.Titulo)
       FROM Livro, Autoria
        WHERE Livro.Codigo = Autoria.Codigo_livro
        AND Autoria.Codigo_autor = a1.Codigo)
          > (SELECT COUNT(Livro.Titulo)
              FROM Livro, Autoria, Autor
              WHERE Autoria.Codigo_livro = Livro.Codigo
              AND Autoria.Codigo_autor = Autor.Codigo
              AND Autor.Nome_autor = 'Navathe');

-- 11
SELECT Aluno.Nome, AVG(Item_emprestado.Multa)
FROM Aluno, Emprestimo, Item_emprestado
WHERE Emprestimo.Codigo_aluno = Aluno.Codigo
    AND Item_emprestado.Codigo_emprestimo = Emprestimo.Codigo
GROUP BY Aluno.Nome
HAVING AVG(Item_emprestado.Multa)
           >
       (SELECT AVG(Item_emprestado.Multa)
        FROM Aluno, Emprestimo, Item_emprestado
        WHERE Emprestimo.Codigo_aluno = Aluno.Codigo
           AND Item_emprestado.Codigo_emprestimo = Emprestimo.Codigo
           AND Aluno.Cidade = 'Belo Horizonte'
           );

-- 12
SELECT Aluno.Nome
FROM Aluno, Emprestimo
WHERE Emprestimo.Codigo_aluno = Aluno.Codigo
GROUP BY Aluno.Nome
HAVING COUNT(DISTINCT Emprestimo.Codigo)
           >
       (SELECT COUNT(*)
           FROM Autor, Autoria, Item_emprestado, Exemplar
           WHERE Autor.Nome_autor = 'Machado de Assis'
           AND Autoria.Codigo_autor = Autor.Codigo
           AND Item_emprestado.Codigo_exemplar = Exemplar.Codigo
           AND Exemplar.Codigo_livro = Autoria.Codigo_livro);

-- 13
SELECT DISTINCT Editora.Nome_editora
FROM Editora, Livro
WHERE Livro.Codigo_editora = Editora.Codigo
GROUP BY Editora.Nome_editora
HAVING COUNT(Livro.Codigo)
           >
       (SELECT COUNT(Livro.Codigo)
        FROM Editora, Livro
        WHERE Livro.Codigo_editora = Editora.Codigo
        AND Editora.Nome_editora = 'Campus');

-- 14
SELECT Livro.Titulo, Aluno.Nome
FROM Livro, Aluno, Item_emprestado, Emprestimo, Exemplar
WHERE Item_emprestado.Codigo_exemplar = Exemplar.Codigo
    AND Exemplar.Codigo_livro = Livro.Codigo
    AND Item_emprestado.Codigo_emprestimo = Emprestimo.Codigo
    AND Aluno.Codigo = Emprestimo.Codigo_aluno
    AND MONTH(Data_emprestimo) = 9
    AND Data_devolucao BETWEEN Data_emprestimo AND DATE_ADD(Data_emprestimo, INTERVAL 2 DAY);

-- 17
DELETE FROM Aluno
WHERE Aluno.Codigo IN
      (SELECT Aluno.Codigo
        FROM Aluno
        EXCEPT
        SELECT Aluno.Codigo
        FROM Aluno, Emprestimo
        WHERE Aluno.Codigo = Emprestimo.Codigo_aluno);

-- 18
UPDATE Livro
SET Codigo_editora = 1
WHERE Codigo_editora = 4;