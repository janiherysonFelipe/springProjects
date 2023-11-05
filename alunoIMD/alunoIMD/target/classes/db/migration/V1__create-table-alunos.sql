CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) UNIQUE,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    matricula VARCHAR(20) NOT NULL,
    curso VARCHAR(100),
    data_de_nascimento VARCHAR(20),
    genero VARCHAR(10),
    data_de_ingresso VARCHAR(20)
);
