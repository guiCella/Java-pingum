CREATE DATABASE pinguin_empresa;

USE pinguin_empresa;

-- Tabela Base: Pinguim
CREATE TABLE pinguim (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    idade INT,
    endereco VARCHAR(255),
    sexo VARCHAR(10),
    altura FLOAT,
    telefone VARCHAR(15)
);

-- Tabela para Funcionários
CREATE TABLE funcionario (
    id INT PRIMARY KEY,
    registro INT NOT NULL,
    salario_peixes INT NOT NULL,
    FOREIGN KEY (id) REFERENCES pinguim(id) ON DELETE CASCADE
);

-- Tabela para Estagiários
CREATE TABLE estagiario (
    id INT PRIMARY KEY,
    registro INT NOT NULL,
    salario_peixes INT NOT NULL,
    FOREIGN KEY (id) REFERENCES pinguim(id) ON DELETE CASCADE
);
