-- =============================================
-- Adicionar ao final do data-dev.sql existente
-- =============================================

-- Endereços dos nutricionistas
INSERT INTO endereco (id, rua, numero, bairro, cidade, estado, pais) VALUES
(100, 'Rua das Flores', 100, 'Centro', 'Sorocaba', 'SP', 'Brasil'),
(101, 'Av. Paulista',   500, 'Bela Vista', 'São Paulo', 'SP', 'Brasil'),
(102, 'Rua da Saúde',   200, 'Savassi', 'Belo Horizonte', 'MG', 'Brasil');

-- Nutricionistas
INSERT INTO nutricionista (id, nome, email, crn, telefone, especialidade, avaliacao, atendimentos_realizados, imagem_url, endereco_id) VALUES
(1, 'Dra. Mariana Costa',   'mariana.costa@nutricao.com',  'CRN-3/12345', '(15) 99876-5432', 'Intolerâncias Alimentares', 5.0, 150, null, 100),
(2, 'Dr. Rafael Mendes',    'rafael.mendes@nutricao.com',  'CRN-3/22222', '(11) 98888-1111', 'Nutrição Esportiva',        4.8, 230, null, 101),
(3, 'Dra. Camila Rocha',    'camila.rocha@nutricao.com',   'CRN-6/33333', '(31) 97777-2222', 'Veganos e Vegetarianos',    4.9, 180, null, 102),
(4, 'Dra. Fernanda Lima',   'fernanda.lima@nutricao.com',  'CRN-3/44444', '(15) 96666-3333', 'Diabetes e Obesidade',      4.7, 120, null, 100),
(5, 'Dr. Lucas Alves',      'lucas.alves@nutricao.com',    'CRN-3/55555', '(15) 95555-4444', 'Restrições Alimentares',    4.6,  90, null, 100);
