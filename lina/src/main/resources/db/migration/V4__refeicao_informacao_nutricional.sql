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

-- Inserindo informações nutricionais para as refeições existentes
INSERT INTO refeicao_informacao_nutricional (
    refeicao_id, porcoes, porcao_label, calorias,
    proteina_g, carboidratos_g, fibras_g, acucares_g,
    gordura_total_g, gordura_saturada_g, gordura_monoinsaturada_g, gordura_poliinsaturada_g,
    colesterol_mg, sal_g, sodio_mg, potassio_mg
) VALUES 
(1, 1, 'Para 1 porção', 220, 12.0, 5.0, 2.0, 1.0, 16.0, 4.0, 3.0, 2.0, 300, 0.5, 200.0, 150.0),
(2, 1, 'Para 1 porção', 180, 8.0, 25.0, 3.0, 15.0, 4.0, 2.0, 1.0, 0.5, 10, 0.1, 50.0, 300.0),
(3, 1, 'Para 1 porção', 250, 10.0, 35.0, 1.0, 1.0, 8.0, 4.0, 2.0, 1.0, 30, 0.8, 400.0, 100.0),
(4, 1, 'Para 1 porção', 210, 7.0, 40.0, 4.0, 20.0, 3.0, 1.5, 1.0, 0.5, 10, 0.1, 60.0, 450.0),
(5, 1, 'Para 1 porção', 400, 35.0, 45.0, 3.0, 2.0, 8.0, 2.0, 3.0, 2.0, 85, 1.2, 500.0, 400.0),
(6, 1, 'Para 1 porção', 420, 30.0, 40.0, 5.0, 3.0, 12.0, 4.0, 5.0, 2.0, 90, 1.0, 450.0, 600.0),
(7, 1, 'Para 1 porção', 350, 28.0, 20.0, 6.0, 4.0, 15.0, 3.0, 6.0, 4.0, 60, 0.8, 300.0, 500.0),
(8, 1, 'Para 1 porção', 300, 15.0, 10.0, 3.0, 2.0, 22.0, 6.0, 8.0, 4.0, 350, 1.0, 400.0, 250.0),
(9, 1, 'Para 1 porção', 180, 5.0, 6.0, 3.0, 1.0, 16.0, 2.0, 8.0, 5.0, 0, 0.0, 5.0, 150.0),
(10, 1, 'Para 1 porção', 200, 4.0, 25.0, 5.0, 18.0, 10.0, 1.5, 4.0, 3.0, 0, 0.1, 50.0, 300.0),
(11, 1, 'Para 1 porção', 160, 3.0, 35.0, 4.0, 25.0, 1.0, 0.2, 0.3, 0.1, 0, 0.0, 20.0, 400.0),
(12, 1, 'Para 1 porção', 250, 20.0, 25.0, 4.0, 3.0, 6.0, 1.5, 2.0, 1.0, 50, 1.5, 600.0, 450.0),
(13, 1, 'Para 1 porção', 280, 25.0, 15.0, 6.0, 4.0, 12.0, 2.5, 5.0, 3.0, 65, 0.9, 350.0, 550.0),
(14, 1, 'Para 1 porção', 220, 14.0, 3.0, 1.0, 1.0, 16.0, 4.5, 6.0, 3.0, 320, 0.7, 280.0, 180.0),
(15, 1, 'Para 1 porção', 240, 8.0, 35.0, 2.0, 1.5, 7.0, 3.0, 2.0, 1.0, 25, 0.8, 380.0, 120.0),
(17, 1, 'Para 1 porção', 190, 6.0, 30.0, 4.0, 12.0, 5.0, 2.5, 1.5, 1.0, 15, 0.1, 70.0, 250.0);
