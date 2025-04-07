
CREATE DATABASE hospital;
USE hospital;

-- Tabela de Usuários do sistema (login)
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

-- Tabela de Médicos
CREATE TABLE medico (
    id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL
    
);

-- Tabela de Pacientes
CREATE TABLE paciente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    idade INT
);

-- Tabela de Consultas
CREATE TABLE consulta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_paciente INT,
    id_medico INT,
    data_consulta DATETIME NOT NULL,
    duracao TEXT,
    prescricao TEXT,
    des_diagnostico TEXT,
    FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    FOREIGN KEY (id_medico) REFERENCES medico(id)
);

insert into usuario (login, senha) values ('admin', 'admin');
insert into usuario (login, senha) values ('operador1', '123456');
insert into usuario (login, senha) values ('usuario1', '654321');