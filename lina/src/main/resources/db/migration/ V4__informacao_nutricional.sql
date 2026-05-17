-- =============================================
-- Lina - V4: Informações nutricionais por refeição
-- =============================================

CREATE TABLE refeicao_informacao_nutricional (
    refeicao_id                  BIGINT PRIMARY KEY REFERENCES refeicao(id) ON DELETE CASCADE,
    porcoes                      INTEGER NOT NULL DEFAULT 1,
    porcao_label                 VARCHAR(100),
    calorias                     DOUBLE PRECISION,
    proteina_g                   DOUBLE PRECISION,
    carboidratos_g               DOUBLE PRECISION,
    fibras_g                     DOUBLE PRECISION,
    acucares_g                   DOUBLE PRECISION,
    gordura_total_g              DOUBLE PRECISION,
    gordura_saturada_g           DOUBLE PRECISION,
    gordura_monoinsaturada_g     DOUBLE PRECISION,
    gordura_poliinsaturada_g     DOUBLE PRECISION,
    colesterol_mg                DOUBLE PRECISION,
    sal_g                        DOUBLE PRECISION,
    sodio_mg                     DOUBLE PRECISION,
    potassio_mg                  DOUBLE PRECISION
);

-- Exemplo: Omelete com Legumes (id = 1)
INSERT INTO refeicao_informacao_nutricional (
    refeicao_id, porcoes, porcao_label, calorias,
    proteina_g, carboidratos_g, fibras_g, acucares_g,
    gordura_total_g, gordura_saturada_g, gordura_monoinsaturada_g, gordura_poliinsaturada_g,
    colesterol_mg, sal_g, sodio_mg, potassio_mg
) VALUES (
    1, 1, 'Para 1 porção', 198,
    4.9, 21.5, 4.2, 3.9,
    10.1, 2.3, 2.0, 4.1,
    1, 0.1, 28.6, 173.3
);