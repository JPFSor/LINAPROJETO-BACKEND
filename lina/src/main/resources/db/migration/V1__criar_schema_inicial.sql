CREATE TABLE endereco (
                          id      BIGSERIAL PRIMARY KEY,
                          numero  INTEGER,
                          bairro  VARCHAR(255),
                          cidade  VARCHAR(255),
                          estado  VARCHAR(255),
                          pais    VARCHAR(255),
                          rua     VARCHAR(255)
);

CREATE TABLE usuario (
                         id                        BIGSERIAL PRIMARY KEY,
                         assinante                 BOOLEAN NOT NULL DEFAULT FALSE,
                         data_inicio_assinatura    DATE,
                         data_nascimento           DATE,
                         data_renovacao_assinatura DATE,
                         endereco_id               BIGINT REFERENCES endereco(id),
                         email                     VARCHAR(255) NOT NULL UNIQUE,
                         imagem_url                VARCHAR(255),
                         nome                      VARCHAR(255),
                         senha                     VARCHAR(255),
                         genero                    VARCHAR(50)
);

CREATE TABLE usuario_restricoes (
                                    usuario_id BIGINT NOT NULL REFERENCES usuario(id),
                                    restricoes VARCHAR(50)
);

CREATE TABLE plano_semanal (
                               id         BIGSERIAL PRIMARY KEY,
                               usuario_id BIGINT NOT NULL UNIQUE REFERENCES usuario(id)
);

CREATE TABLE cardapio (
                          id               BIGSERIAL PRIMARY KEY,
                          plano_semanal_id BIGINT REFERENCES plano_semanal(id),
                          dia_semana       VARCHAR(20),
                          UNIQUE (plano_semanal_id, dia_semana)
);

CREATE TABLE ingrediente (
                             id        BIGSERIAL PRIMARY KEY,
                             nome      VARCHAR(255),
                             categoria VARCHAR(50)
);

CREATE TABLE refeicao (
                          id            BIGSERIAL PRIMARY KEY,
                          calorias      DOUBLE PRECISION NOT NULL,
                          tempo_preparo INTEGER,
                          modo_preparo  VARCHAR(2000),
                          imagem_url    VARCHAR(255),
                          nome          VARCHAR(255)
);

CREATE TABLE refeicao_periodos_permitidos (
                                              refeicao_id         BIGINT NOT NULL REFERENCES refeicao(id),
                                              periodos_permitidos VARCHAR(50)
);

CREATE TABLE refeicao_restricoes (
                                     refeicao_id BIGINT NOT NULL REFERENCES refeicao(id),
                                     restricoes  VARCHAR(50)
);

CREATE TABLE refeicao_ingrediente (
                                      id             BIGSERIAL PRIMARY KEY,
                                      quantidade     DOUBLE PRECISION NOT NULL,
                                      ingrediente_id BIGINT REFERENCES ingrediente(id),
                                      refeicao_id    BIGINT REFERENCES refeicao(id),
                                      unidade        VARCHAR(255)
);

CREATE TABLE item_cardapio (
                               id          BIGSERIAL PRIMARY KEY,
                               cardapio_id BIGINT NOT NULL REFERENCES cardapio(id),
                               refeicao_id BIGINT NOT NULL REFERENCES refeicao(id),
                               periodo     VARCHAR(50),
                               UNIQUE (cardapio_id, periodo, refeicao_id)
);

CREATE TABLE nutricionista (
                               id                      BIGSERIAL PRIMARY KEY,
                               atendimentos_realizados INTEGER NOT NULL,
                               avaliacao               INTEGER NOT NULL,
                               endereco_id             BIGINT REFERENCES endereco(id),
                               crn                     VARCHAR(255),
                               email                   VARCHAR(255),
                               especialidade           VARCHAR(255),
                               imagem_url              VARCHAR(255),
                               nome                    VARCHAR(255),
                               telefone                VARCHAR(255)
);