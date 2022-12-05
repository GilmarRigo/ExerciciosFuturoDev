INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, senha, nome) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'gilmarigo', '123', 'Gilmar');
INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, senha, nome) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'gilbertootavio', '1234', 'Gilberto');
INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, senha, nome) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'brenda', '12345', 'Brenda');
INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, senha, nome) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'betina', '12346', 'Betina');
INSERT INTO public.usuario(data_atualizacao, data_cadastro, login, senha, nome) VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'patricia', '12374', 'Patrícia');

INSERT INTO public.produto (descricao, preco_unitario) VALUES ('Laranja', 4.4);

INSERT INTO public.telefone (numero, tipo, id_usuario) VALUES ('99999999', 'Celular', 1);

INSERT INTO public.cliente(data_atualizacao, data_cadastro, nome, telefone)	VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'Brenda', '4799999');