-- =============================================
-- Lina - V3: Seed de refeições e ingredientes (produção)
-- Roda automaticamente via Flyway no perfil prod.
-- =============================================

-- Ingredientes
INSERT INTO ingrediente (id, nome, categoria) VALUES
(1,  'Ovo',            'PROTEINAS'),
(2,  'Abobrinha',      'FRUTAS_E_VEGETAIS'),
(3,  'Tomate',         'FRUTAS_E_VEGETAIS'),
(4,  'Azeite',         'OUTROS'),
(5,  'Peixe Tilápia',  'PROTEINAS'),
(6,  'Batata Doce',    'FRUTAS_E_VEGETAIS'),
(7,  'Abacate',        'FRUTAS_E_VEGETAIS'),
(8,  'Leite de Aveia', 'LATICINIOS'),
(9,  'Arroz Integral', 'GRAOS_E_CEREAIS'),
(10, 'Feijão Carioca', 'GRAOS_E_CEREAIS');

-- Refeições
INSERT INTO refeicao (id, nome, tempo_preparo, calorias, modo_preparo, imagem_url) VALUES
(1, 'Omelete com Vegetais',        15, 280, 'Bata 3 ovos, misture a abobrinha e o tomate picados. Cozinhe em frigideira antiaderente com azeite por 5 min.', NULL),
(2, 'Peixe Assado com Batata Doce', 30, 420, 'Tempere o peixe com sal e limão. Asse a 180°C por 20 min. Cozinhe a batata doce no vapor.',                   NULL),
(3, 'Vitamina de Abacate',          10, 310, 'Bata o abacate com leite de aveia e mel a gosto no liquidificador.',                                            NULL),
(4, 'Arroz com Feijão',             40, 380, 'Cozinhe o arroz integral separado. Refogue o feijão com alho e sal.',                                           NULL);

-- Períodos permitidos por refeição
INSERT INTO refeicao_periodos_permitidos (refeicao_id, periodos_permitidos) VALUES
(1, 'CAFE_DA_MANHA'),
(2, 'ALMOCO'),
(2, 'JANTAR'),
(3, 'LANCHE_DA_TARDE'),
(3, 'CAFE_DA_MANHA'),
(4, 'ALMOCO'),
(4, 'JANTAR');

-- Restrições que cada refeição NÃO atende
-- (refeições com VEGANO aqui são omitidas para usuários veganos)
INSERT INTO refeicao_restricoes (refeicao_id, restricoes) VALUES
(1, 'VEGANO'),
(2, 'VEGANO'),
(2, 'VEGETARIANO');

-- Relação refeição <-> ingredientes (com quantidades)
INSERT INTO refeicao_ingrediente (id, refeicao_id, ingrediente_id, quantidade, unidade) VALUES
(1,  1, 1,  3,   'unidades'),
(2,  1, 2,  100, 'g'),
(3,  1, 3,  50,  'g'),
(4,  1, 4,  10,  'ml'),
(5,  2, 5,  200, 'g'),
(6,  2, 6,  150, 'g'),
(7,  3, 7,  100, 'g'),
(8,  3, 8,  200, 'ml'),
(9,  4, 9,  100, 'g'),
(10, 4, 10,  80, 'g');
