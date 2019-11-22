-- drop database Biblioteca;
-- create database Biblioteca;

USE Biblioteca;

-- @block create table Autor
CREATE TABLE IF NOT EXISTS Autor (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome_autor NVARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

-- @block create table Editora
CREATE TABLE IF NOT EXISTS Editora (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome_editora NVARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

-- @block create table Assunto
CREATE TABLE IF NOT EXISTS Assunto (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Descricao NVARCHAR(200) NOT NULL,
    PRIMARY KEY (Codigo)
);

-- @block create table Livro
CREATE TABLE IF NOT EXISTS Livro (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Titulo NVARCHAR(40) NOT NULL,
    Ano_pub INTEGER NOT NULL,
    Codigo_editora INTEGER NOT NULL,
    Codigo_assunto INTEGER NOT NULL,
    PRIMARY KEY (Codigo)
);

-- @block create table Autoria
CREATE TABLE IF NOT EXISTS Autoria (
    Codigo_livro INTEGER NOT NULL,
    Codigo_autor INTEGER NOT NULL,
    PRIMARY KEY (Codigo_livro, Codigo_autor),
    FOREIGN KEY (Codigo_livro) REFERENCES Livro (Codigo),
    FOREIGN KEY (Codigo_autor) REFERENCES Autor (Codigo)
);

-- @block create table Exemplar
CREATE TABLE IF NOT EXISTS Exemplar (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Codigo_livro INTEGER NOT NULL,
    Data_aquisicao DATE NOT NULL,
    Valor_aquisicao FLOAT NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (Codigo_livro) REFERENCES Livro (Codigo)
);

-- @block create table Aluno
CREATE TABLE IF NOT EXISTS Aluno (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Nome NVARCHAR(50) NOT NULL,
    Data_nascimento DATE NOT NULL,
    Cidade VARCHAR(50) NOT NULL,
    PRIMARY KEY (Codigo)
);

-- @block create table Emprestimo
CREATE TABLE IF NOT EXISTS Emprestimo (
    Codigo INTEGER NOT NULL AUTO_INCREMENT,
    Data_emprestimo DATE NOT NULL,
    Codigo_aluno INTEGER NOT NULL,
    PRIMARY KEY (Codigo),
    FOREIGN KEY (Codigo_aluno) REFERENCES Aluno (Codigo)
);

-- @block create table Item_emprestado
CREATE TABLE IF NOT EXISTS Item_emprestado (
    Codigo_emprestimo INTEGER NOT NULL,
    Item INTEGER NOT NULL,
    Codigo_exemplar INTEGER NOT NULL,
    Data_devolucao DATE NOT NULL,
    Multa FLOAT NOT NULL,
    PRIMARY KEY (Codigo_emprestimo, Item),
    FOREIGN KEY (Codigo_emprestimo) REFERENCES Emprestimo (Codigo),
    FOREIGN KEY (Codigo_exemplar) REFERENCES Exemplar (Codigo),
    UNIQUE (Item)
);

INSERT INTO Aluno (Nome, Data_nascimento, Cidade)
VALUES ('Luiz Junio', '1999-09-16', 'Belo Horizonte'),
       ('Allan Vivekananda', '1998-03-14', 'Justinópolis'),
       ('Henrique Fernandes', '2000-08-01', 'Belo Horizonte'),
       ('Bernardo Valadares', '1999-10-22', 'São Paulo');

INSERT INTO Autor (Nome_autor)
VALUES ('Carlos Drummond de Andrade'),
       ('Euclides da Cunha'),
       ('Machado de Assis'),
       ('Mário de Andrade'),
       ('Monteiro Lobato');


