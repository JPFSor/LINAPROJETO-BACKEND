-- =============================================
-- Lina - Seed de dados para desenvolvimento (H2)
-- Dados reais do Notion — mesmos do V3 de produção.
-- Roda automaticamente no perfil DEV.
-- =============================================

-- ── INGREDIENTES ──────────────────────────────
INSERT INTO ingrediente (id, nome, categoria) VALUES
(1,  'Ovo',               'PROTEINAS'),
(2,  'Tomate',            'FRUTAS_E_VEGETAIS'),
(3,  'Cebola',            'FRUTAS_E_VEGETAIS'),
(4,  'Pimentão',          'FRUTAS_E_VEGETAIS'),
(5,  'Azeite',            'OUTROS'),
(6,  'Iogurte',           'LATICINIOS'),
(7,  'Banana',            'FRUTAS_E_VEGETAIS'),
(8,  'Chia',              'GRAOS_E_CEREAIS'),
(9,  'Goma de Tapioca',   'GRAOS_E_CEREAIS'),
(10, 'Queijo',            'LATICINIOS'),
(11, 'Leite',             'LATICINIOS'),
(12, 'Aveia',             'GRAOS_E_CEREAIS'),
(13, 'Frango',            'PROTEINAS'),
(14, 'Arroz',             'GRAOS_E_CEREAIS'),
(15, 'Salada (mix)',      'FRUTAS_E_VEGETAIS'),
(16, 'Carne Bovina',      'PROTEINAS'),
(17, 'Batata Doce',       'FRUTAS_E_VEGETAIS'),
(18, 'Filé de Peixe',     'PROTEINAS'),
(19, 'Legumes (mix)',     'FRUTAS_E_VEGETAIS'),
(20, 'Castanhas (mix)',   'OUTROS'),
(21, 'Maçã',              'FRUTAS_E_VEGETAIS'),
(22, 'Pasta de Amendoim', 'OUTROS'),
(23, 'Frutas (mix)',      'FRUTAS_E_VEGETAIS'),
(24, 'Granola',           'GRAOS_E_CEREAIS'),
(25, 'Folhas Verdes',     'FRUTAS_E_VEGETAIS'),
(26, 'Sal',               'OUTROS');

-- ── REFEIÇÕES ─────────────────────────────────
INSERT INTO refeicao (id, nome, tempo_preparo, calorias, modo_preparo, imagem_url) VALUES
(1,  'Omelete com Legumes',    10, 220, '1. Quebre os ovos em uma tigela. 2. Bata até ficar homogêneo. 3. Aqueça o azeite. 4. Refogue os legumes. 5. Adicione os ovos. 6. Cozinhe até firmar. 7. Sirva.', 'https://drive.google.com/file/d/1_Ezukv-5cm4KP1Vkbt12edARQL0G5Ial/view'),
(2,  'Iogurte com Frutas',     5,  180, '1. Coloque o iogurte na tigela. 2. Corte a banana. 3. Adicione ao iogurte. 4. Acrescente a chia. 5. Misture e sirva.', 'https://drive.google.com/file/d/1sPEt72SQp0cY81djkZhKvxP6_C-kdth8/view'),
(3,  'Tapioca com Queijo',     8,  250, '1. Aqueça a frigideira. 2. Espalhe a tapioca. 3. Aguarde firmar. 4. Adicione o queijo. 5. Dobre. 6. Sirva.', 'https://drive.google.com/file/d/1xbpzD1MHC_SXImYsgqHgbkPPBJnbuavP/view'),
(4,  'Vitamina de Banana',     5,  210, '1. Corte a banana. 2. Coloque no liquidificador. 3. Adicione leite e aveia. 4. Bata por 1 minuto. 5. Sirva.', 'https://drive.google.com/file/d/1wc5PpPl1EETnd0yv-W6Mofp8Jq1fdzFC/view'),
(5,  'Frango com Arroz',       25, 400, '1. Tempere o frango. 2. Grelhe por 5-7 min cada lado. 3. Cozinhe o arroz. 4. Prepare a salada. 5. Monte o prato.', 'https://drive.google.com/file/d/18bwglLwymT2CDWrW-GWzGmf40Cd4TrlN/view'),
(6,  'Carne com Batata Doce',  30, 420, '1. Corte a batata. 2. Cozinhe por 15 min. 3. Tempere a carne. 4. Grelhe por 4-6 min. 5. Sirva.', 'https://drive.google.com/file/d/1iSHlmxPhQ8XIUnKj-7Kox3xPRbgWrzwk/view'),
(7,  'Peixe com Legumes',      25, 350, '1. Tempere o peixe. 2. Corte os legumes. 3. Coloque na assadeira. 4. Asse por 20 min. 5. Sirva.', 'https://drive.google.com/file/d/1hYujTnTz0EhqvL-EJUP0aXFEutFRLbi1/view'),
(8,  'Omelete Completo',       15, 300, '1. Bata os ovos. 2. Refogue os legumes. 3. Adicione os ovos. 4. Cozinhe até firmar. 5. Sirva.', 'https://drive.google.com/file/d/1G3cxbOC3MS8Yh2K7OyTBr6VtDrKINKhC/view'),
(9,  'Mix de Castanhas',       2,  180, '1. Separe a porção. 2. Consuma diretamente.', 'https://drive.google.com/file/d/1ERAcJaNs6Z0xzorqEHWgsWNOIt4ctx7H/view'),
(10, 'Maçã com Pasta',         5,  200, '1. Lave a maçã. 2. Corte em fatias. 3. Retire o miolo. 4. Adicione a pasta. 5. Sirva.', 'https://drive.google.com/file/d/1lnjo9eASvPaQBBUhK_bl_JKWdgl_mWIK/view'),
(11, 'Smoothie',               5,  160, '1. Corte as frutas. 2. Coloque no liquidificador. 3. Adicione o líquido. 4. Bata. 5. Sirva.', 'https://drive.google.com/file/d/10xrajIIZXlZ0SH7CMHc9QZfIF6qlBAbB/view'),
(12, 'Sopa',                   30, 250, '1. Corte o frango. 2. Corte os legumes. 3. Coloque tudo na panela. 4. Cozinhe 25 min. 5. Ajuste o sal.', 'https://drive.google.com/file/d/1yJf67bps2unA6zyLX9DQi-OfG_0gZBzw/view'),
(13, 'Salada Proteica',        15, 280, '1. Lave as folhas. 2. Prepare a proteína. 3. Misture tudo. 4. Tempere. 5. Sirva.', 'https://drive.google.com/file/d/1fSQt8DKz7Tgmc5XPxGsIIpMRa8hbIHOD/view'),
(14, 'Omelete Leve',           10, 220, '1. Quebre os ovos. 2. Bata bem. 3. Aqueça a frigideira. 4. Despeje os ovos. 5. Cozinhe até firmar. 6. Sirva.', 'https://drive.google.com/file/d/1X9gyPVxuzZQfx-gLtfeczgF4Gak8lZ5e/view'),
(15, 'Tapioca com Recheio',    10, 240, '1. Aqueça a frigideira. 2. Espalhe a tapioca. 3. Aguarde firmar. 4. Adicione o recheio. 5. Dobre. 6. Sirva.', 'https://drive.google.com/file/d/1gSkrQ47_kbBUoY33DxaSOSuwOKd8TnPw/view'),
(17, 'Iogurte com Granola',    3,  190, '1. Coloque o iogurte. 2. Adicione a granola. 3. Misture. 4. Sirva.', 'https://drive.google.com/file/d/1hut_9swLkrZGknZJwThhwnF5x8oohyqS/view');

-- ── PERÍODOS PERMITIDOS ───────────────────────
INSERT INTO refeicao_periodos_permitidos (refeicao_id, periodos_permitidos) VALUES
(1,  'CAFE_DA_MANHA'),
(2,  'CAFE_DA_MANHA'),
(3,  'CAFE_DA_MANHA'),
(4,  'CAFE_DA_MANHA'),
(5,  'ALMOCO'),
(6,  'ALMOCO'),
(7,  'ALMOCO'),
(8,  'ALMOCO'),
(9,  'LANCHE_DA_TARDE'),
(10, 'LANCHE_DA_TARDE'),
(11, 'LANCHE_DA_TARDE'),
(17, 'LANCHE_DA_TARDE'),
(12, 'JANTAR'),
(13, 'JANTAR'),
(14, 'JANTAR'),
(15, 'JANTAR');

-- ── RESTRIÇÕES ────────────────────────────────
INSERT INTO refeicao_restricoes (refeicao_id, restricoes) VALUES
(1,  'VEGANO'),
(2,  'VEGANO'),
(2,  'LACTOSE'),
(3,  'VEGANO'),
(3,  'LACTOSE'),
(4,  'VEGANO'),
(4,  'LACTOSE'),
(5,  'VEGANO'),
(5,  'VEGETARIANO'),
(6,  'VEGANO'),
(6,  'VEGETARIANO'),
(7,  'VEGANO'),
(7,  'VEGETARIANO'),
(8,  'VEGANO'),
(17, 'VEGANO'),
(17, 'LACTOSE'),
(12, 'VEGANO'),
(12, 'VEGETARIANO'),
(13, 'VEGANO'),
(14, 'VEGANO'),
(15, 'VEGANO');

-- ── INGREDIENTES POR REFEIÇÃO ─────────────────
INSERT INTO refeicao_ingrediente (id, refeicao_id, ingrediente_id, quantidade, unidade) VALUES
(1,  1,  1,  2,    'unidades'),
(2,  1,  2,  0.5,  'xícara'),
(3,  1,  3,  0.25, 'xícara'),
(4,  1,  4,  0.25, 'xícara'),
(5,  1,  5,  1,    'colher'),
(6,  1,  26, 1,    'pitada'),
(7,  2,  6,  1,    'pote'),
(8,  2,  7,  1,    'unidade'),
(9,  2,  8,  1,    'colher'),
(10, 3,  9,  2,    'colheres'),
(11, 3,  10, 1,    'fatia'),
(12, 4,  7,  1,    'unidade'),
(13, 4,  11, 200,  'ml'),
(14, 4,  12, 2,    'colheres'),
(15, 5,  13, 100,  'g'),
(16, 5,  14, 0.5,  'xícara'),
(17, 5,  15, 1,    'xícara'),
(18, 5,  5,  1,    'colher'),
(19, 6,  16, 100,  'g'),
(20, 6,  17, 1,    'unidade'),
(21, 7,  18, 1,    'filé'),
(22, 7,  19, 1,    'xícara'),
(23, 7,  5,  1,    'colher'),
(24, 8,  1,  3,    'unidades'),
(25, 8,  19, 0.5,  'xícara'),
(26, 8,  5,  1,    'colher'),
(27, 9,  20, 30,   'g'),
(28, 10, 21, 1,    'unidade'),
(29, 10, 22, 1,    'colher'),
(30, 11, 23, 1,    'xícara'),
(31, 11, 11, 200,  'ml'),
(32, 12, 13, 100,  'g'),
(33, 12, 19, 1,    'xícara'),
(34, 12, 26, 1,    'pitada'),
(35, 13, 25, 1,    'xícara'),
(36, 13, 13, 100,  'g'),
(37, 13, 5,  1,    'colher'),
(38, 14, 1,  2,    'unidades'),
(39, 14, 26, 1,    'pitada'),
(40, 15, 9,  2,    'colheres'),
(41, 17, 6,  1,    'pote'),
(42, 17, 24, 2,    'colheres');

-- Endereços dos nutricionistas
INSERT INTO endereco (id, rua, numero, bairro, cidade, estado, pais) VALUES
(100, 'Rua das Flores', 100, 'Centro', 'Sorocaba', 'SP', 'Brasil'),
(101, 'Av. Paulista',   500, 'Bela Vista', 'São Paulo', 'SP', 'Brasil'),
(102, 'Rua da Saúde',   200, 'Savassi', 'Belo Horizonte', 'MG', 'Brasil');

-- Nutricionistas
INSERT INTO nutricionista (id, nome, email, crn, telefone, especialidade, avaliacao, atendimentos_realizados, imagem_url, endereco_id) VALUES
(1, 'Dra. Mariana Costa',   'mariana.costa@nutricao.com',  'CRN-3/12345', '(15) 99876-5432', 'Intolerâncias Alimentares', 5, 150, null, 100),
(2, 'Dr. Rafael Mendes',    'rafael.mendes@nutricao.com',  'CRN-3/22222', '(11) 98888-1111', 'Nutrição Esportiva',        5, 230, null, 101),
(3, 'Dra. Camila Rocha',    'camila.rocha@nutricao.com',   'CRN-6/33333', '(31) 97777-2222', 'Veganos e Vegetarianos',    4, 180, null, 102),
(4, 'Dra. Fernanda Lima',   'fernanda.lima@nutricao.com',  'CRN-3/44444', '(15) 96666-3333', 'Diabetes e Obesidade',      4, 120, null, 100),
(5, 'Dr. Lucas Alves',      'lucas.alves@nutricao.com',    'CRN-3/55555', '(15) 95555-4444', 'Restrições Alimentares',    3,  90, null, 100);


-- ── RESETAR AUTO-INCREMENT DO H2 ──────────────
ALTER TABLE ingrediente ALTER COLUMN id RESTART WITH 27;
ALTER TABLE refeicao ALTER COLUMN id RESTART WITH 18;
ALTER TABLE refeicao_ingrediente ALTER COLUMN id RESTART WITH 43;
