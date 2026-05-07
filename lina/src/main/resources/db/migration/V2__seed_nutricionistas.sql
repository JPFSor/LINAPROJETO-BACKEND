-- =============================================
-- Lina - V2: Seed de nutricionistas (produção)
-- Roda automaticamente via Flyway no perfil prod.
-- IDs explícitos garantem idempotência — não altere
-- os valores se já tiver rodado em produção.
-- =============================================

INSERT INTO endereco (id, rua, numero, bairro, cidade, estado, pais) VALUES
(1, 'Rua das Flores',  100, 'Centro',     'Sorocaba',        'SP', 'Brasil'),
(2, 'Av. Paulista',    500, 'Bela Vista', 'São Paulo',        'SP', 'Brasil'),
(3, 'Rua da Saúde',    200, 'Savassi',    'Belo Horizonte',   'MG', 'Brasil');

INSERT INTO nutricionista (id, nome, email, crn, telefone, especialidade, avaliacao, atendimentos_realizados, imagem_url, endereco_id) VALUES
(1, 'Dra. Mariana Costa',  'mariana.costa@nutricao.com',  'CRN-3/12345', '(15) 99876-5432', 'Intolerâncias Alimentares', 5, 150, NULL, 1),
(2, 'Dr. Rafael Mendes',   'rafael.mendes@nutricao.com',  'CRN-3/22222', '(11) 98888-1111', 'Nutrição Esportiva',        5, 230, NULL, 2),
(3, 'Dra. Camila Rocha',   'camila.rocha@nutricao.com',   'CRN-6/33333', '(31) 97777-2222', 'Veganos e Vegetarianos',    4, 180, NULL, 3),
(4, 'Dra. Fernanda Lima',  'fernanda.lima@nutricao.com',  'CRN-3/44444', '(15) 96666-3333', 'Diabetes e Obesidade',      4, 120, NULL, 1),
(5, 'Dr. Lucas Alves',     'lucas.alves@nutricao.com',    'CRN-3/55555', '(15) 95555-4444', 'Restrições Alimentares',    3,  90, NULL, 1);
