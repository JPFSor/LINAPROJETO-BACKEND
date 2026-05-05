-- =============================================
-- Lina - Seed de dados para desenvolvimento (H2)
-- Roda automaticamente no perfil DEV
-- =============================================

-- Ingredientes
INSERT INTO ingrediente (id, nome, categoria)
VALUES (1, 'Ovo', 'PROTEINAS'),
       (2, 'Abobrinha', 'FRUTAS_E_VEGETAIS'),
       (3, 'Tomate', 'FRUTAS_E_VEGETAIS'),
       (4, 'Azeite', 'OUTROS'),
       (5, 'Peixe Tilápia', 'PROTEINAS'),
       (6, 'Batata Doce', 'FRUTAS_E_VEGETAIS'),
       (7, 'Abacate', 'FRUTAS_E_VEGETAIS'),
       (8, 'Leite de Aveia', 'LATICINIOS'),
       (9, 'Arroz Integral', 'GRAOS_E_CEREAIS'),
       (10, 'Feijão Carioca', 'GRAOS_E_CEREAIS');

-- Refeições
INSERT INTO refeicao (id, nome, tempo_preparo, calorias, modo_preparo, imagem_url)
VALUES (1, 'Omelete com Vegetais', 15, 280,
        'Bata 3 ovos, misture a abobrinha e o tomate picados. Cozinhe em frigideira antiaderente com azeite por 5 min.',
        'https://placeholder.com/omelete.jpg'),
       (2, 'Peixe Assado com Batata Doce', 30, 420,
        'Tempere o peixe com sal e limão. Asse a 180°C por 20 min. Cozinhe a batata doce no vapor.',
        'https://placeholder.com/peixe.jpg'),
       (3, 'Vitamina de Abacate', 10, 310, 'Bata o abacate com leite de aveia e mel a gosto no liquidificador.',
        'https://placeholder.com/vitamina.jpg'),
       (4, 'Arroz com Feijão', 40, 380, 'Cozinhe o arroz integral separado. Refogue o feijão com alho e sal.',
        'https://placeholder.com/arrozfeijao.jpg');

-- Períodos permitidos por refeição
INSERT INTO refeicao_periodos_permitidos (refeicao_id, periodos_permitidos)
VALUES (1, 'CAFE_DA_MANHA'),
       (2, 'ALMOCO'),
       (2, 'JANTAR'),
       (3, 'LANCHE_DA_TARDE'),
       (3, 'CAFE_DA_MANHA'),
       (4, 'ALMOCO'),
       (4, 'JANTAR');

-- Restrições que cada refeição NÃO atende
-- (se a refeição tem LACTOSE aqui, ela não aparece para usuários intolerantes)
-- Omelete tem ovo — não serve para veganos
INSERT INTO refeicao_restricoes (refeicao_id, restricoes)
VALUES (1, 'VEGANO'),
       (2, 'VEGANO'),
       (2, 'VEGETARIANO');

-- Relação refeição <-> ingredientes
INSERT INTO refeicao_ingrediente (id, refeicao_id, ingrediente_id, quantidade, unidade)
VALUES (1, 1, 1, 3, 'unidades'),
       (2, 1, 2, 100, 'g'),
       (3, 1, 3, 50, 'g'),
       (4, 1, 4, 10, 'ml'),
       (5, 2, 5, 200, 'g'),
       (6, 2, 6, 150, 'g'),
       (7, 3, 7, 100, 'g'),
       (8, 3, 8, 200, 'ml'),
       (9, 4, 9, 100, 'g'),
       (10, 4, 10, 80, 'g');

-- =============================================
-- Adicionar ao final do data-dev.sql existente
-- =============================================

-- Endereços dos nutricionistas
INSERT INTO endereco (id, rua, numero, bairro, cidade, estado, pais)
VALUES (100, 'Rua das Flores', 100, 'Centro', 'Sorocaba', 'SP', 'Brasil'),
       (101, 'Av. Paulista', 500, 'Bela Vista', 'São Paulo', 'SP', 'Brasil'),
       (102, 'Rua da Saúde', 200, 'Savassi', 'Belo Horizonte', 'MG', 'Brasil');

-- Nutricionistas
INSERT INTO nutricionista (id, nome, email, crn, telefone, especialidade, avaliacao, atendimentos_realizados,
                           imagem_url, endereco_id)
VALUES (1, 'Dra. Mariana Costa', 'mariana.costa@nutricao.com', 'CRN-3/12345', '(15) 99876-5432', 'Intolerâncias Alimentares', 5.0, 150, null, 100),
       (2, 'Dr. Rafael Mendes', 'rafael.mendes@nutricao.com', 'CRN-3/22222', '(11) 98888-1111', 'Nutrição Esportiva', 4.0, 230, null, 101),
       (3, 'Dra. Camila Rocha', 'camila.rocha@nutricao.com', 'CRN-6/33333', '(31) 97777-2222', 'Veganos e Vegetarianos', 4.0, 180, null, 102),
       (4, 'Dra. Fernanda Lima', 'fernanda.lima@nutricao.com', 'CRN-3/44444', '(15) 96666-3333', 'Diabetes e Obesidade', 3.0, 120, null, 100),
       (5, 'Dr. Lucas Alves', 'lucas.alves@nutricao.com', 'CRN-3/55555', '(15) 95555-4444', 'Restrições Alimentares', 2.0, 90, null, 100);


-- =============================================
-- Resetar sequences do H2 para evitar conflito
-- com os IDs fixos inseridos acima.
-- O H2 gera sequences com o padrão <tabela>_SEQ.
-- =============================================
ALTER TABLE ingrediente
    ALTER COLUMN id RESTART WITH 11;
ALTER TABLE refeicao
    ALTER COLUMN id RESTART WITH 5;
ALTER TABLE refeicao_ingrediente
    ALTER COLUMN id RESTART WITH 11;
