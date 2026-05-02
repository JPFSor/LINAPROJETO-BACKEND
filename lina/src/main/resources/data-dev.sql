-- =============================================
-- Lina - Seed de dados para desenvolvimento (H2)
-- Roda automaticamente no perfil DEV
-- =============================================

-- Ingredientes
INSERT INTO ingrediente (id, nome, categoria) VALUES
(1, 'Ovo', 'PROTEINA'),
(2, 'Abobrinha', 'VEGETAL'),
(3, 'Tomate', 'VEGETAL'),
(4, 'Azeite', 'GORDURA'),
(5, 'Peixe Tilápia', 'PROTEINA'),
(6, 'Batata Doce', 'CARBOIDRATO'),
(7, 'Abacate', 'GORDURA'),
(8, 'Leite de Aveia', 'CARBOIDRATO'),
(9, 'Arroz Integral', 'CARBOIDRATO'),
(10, 'Feijão Carioca', 'PROTEINA');

-- Refeições
INSERT INTO refeicao (id, nome, tempo_preparo, calorias, modo_preparo, imagem_url) VALUES
(1, 'Omelete com Vegetais',   15, 280, 'Bata 3 ovos, misture a abobrinha e o tomate picados. Cozinhe em frigideira antiaderente com azeite por 5 min.', 'https://placeholder.com/omelete.jpg'),
(2, 'Peixe Assado com Batata Doce', 30, 420, 'Tempere o peixe com sal e limão. Asse a 180°C por 20 min. Cozinhe a batata doce no vapor.', 'https://placeholder.com/peixe.jpg'),
(3, 'Vitamina de Abacate',    10, 310, 'Bata o abacate com leite de aveia e mel a gosto no liquidificador.', 'https://placeholder.com/vitamina.jpg'),
(4, 'Arroz com Feijão',       40, 380, 'Cozinhe o arroz integral separado. Refogue o feijão com alho e sal.', 'https://placeholder.com/arrozfeijao.jpg');

-- Períodos permitidos por refeição
INSERT INTO refeicao_periodos_permitidos (refeicao_id, periodos_permitidos) VALUES
(1, 'CAFE_MANHA'),
(2, 'ALMOCO'),
(2, 'JANTAR'),
(3, 'LANCHE_TARDE'),
(3, 'CAFE_MANHA'),
(4, 'ALMOCO'),
(4, 'JANTAR');

-- Restrições que cada refeição NÃO atende
-- (se a refeição tem LACTOSE aqui, ela não aparece para usuários intolerantes)
-- Omelete tem ovo — não serve para veganos
INSERT INTO refeicao_restricoes (refeicao_id, restricoes) VALUES
(1, 'VEGANO'),
(1, 'VEGETARIANO');

-- Relação refeição <-> ingredientes
INSERT INTO refeicao_ingrediente (id, refeicao_id, ingrediente_id, quantidade, unidade) VALUES
(1, 1, 1, 3,   'unidades'),
(2, 1, 2, 100, 'g'),
(3, 1, 3, 50,  'g'),
(4, 1, 4, 10,  'ml'),
(5, 2, 5, 200, 'g'),
(6, 2, 6, 150, 'g'),
(7, 3, 7, 100, 'g'),
(8, 3, 8, 200, 'ml'),
(9, 4, 9, 100, 'g'),
(10, 4, 10, 80, 'g');
