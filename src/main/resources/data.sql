INSERT INTO instituicao (id, nome) SELECT 1, 'PUC Minas' WHERE NOT EXISTS (SELECT 1 FROM instituicao WHERE id = 1);
INSERT INTO instituicao (id, nome) SELECT 2, 'UFMG' WHERE NOT EXISTS (SELECT 1 FROM instituicao WHERE id = 2);

INSERT INTO curso (id, nome, instituicao_id) SELECT 1, 'Engenharia de Software', 1 WHERE NOT EXISTS (SELECT 1 FROM curso WHERE id = 1);
INSERT INTO curso (id, nome, instituicao_id) SELECT 2, 'Ciência da Computação', 1 WHERE NOT EXISTS (SELECT 1 FROM curso WHERE id = 2);
INSERT INTO curso (id, nome, instituicao_id) SELECT 3, 'Sistemas de Informação', 2 WHERE NOT EXISTS (SELECT 1 FROM curso WHERE id = 3);
