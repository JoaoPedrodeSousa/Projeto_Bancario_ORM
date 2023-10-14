CREATE TABLE contas (
    id SERIAL PRIMARY KEY,
    numero_conta VARCHAR(10) UNIQUE NOT NULL,
    saldo NUMERIC(10, 2) NOT NULL,
    titular VARCHAR(100) NOT NULL
);

CREATE TABLE transacoes (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(20) NOT NULL,
    data TIMESTAMP DEFAULT NOW(),
    valor NUMERIC(10, 2) NOT NULL,
    conta_origem Integer,
    conta_destino Integer,
    FOREIGN KEY (conta_origem) REFERENCES contas(id),
    FOREIGN KEY (conta_destino) REFERENCES contas(id)
);

CREATE TABLE emprestimos (
    id SERIAL PRIMARY KEY,
    id_conta Integer,
    valor_emprestimo NUMERIC(10, 2) NOT NULL,
    taxa_juros NUMERIC(5, 2) NOT NULL,
    prazo_meses INT NOT NULL,
    status VARCHAR(20) DEFAULT 'PENDENTE',
    FOREIGN KEY (id_conta) REFERENCES contas(id)
);

CREATE TABLE investimentos (
    id SERIAL PRIMARY KEY,
    id_conta Integer,
    tipo_ativo VARCHAR(50) NOT NULL,
    valor_investido NUMERIC(10, 2) NOT NULL,
    data_investimento DATE NOT NULL,
    FOREIGN KEY (id_conta) REFERENCES contas(id)
);