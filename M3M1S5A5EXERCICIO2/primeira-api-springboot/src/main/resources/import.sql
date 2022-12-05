INSERT INTO public.usuario(login, senha, nome) VALUES ('gilmarigo', '123', 'Gilmar');

INSERT INTO public.produto (descricao, preco_unitario) VALUES ('Laranja', 4.4);

INSERT INTO public.telefone (numero, tipo, id_usuario) VALUES ('99999999', 'Celular', 1);

INSERT INTO public.cliente(data_atualizacao, data_cadastro, nome, telefone)	VALUES (timezone('utc', CURRENT_TIMESTAMP(0)), timezone('utc', CURRENT_TIMESTAMP(0)), 'Brenda', '4799999');

INSERT INTO public.role(nome_role) VALUES ('ROLE_ADMIN');
INSERT INTO public.role(nome_role) VALUES ('ROLE_CAIXA');

INSERT INTO public.usuario(login, nome, senha) VALUES ('brunomoura', 'Bruno Moura', '$2a$10$8okjbHGqFzdFAX.XtVBO6eEZWi4F7W285Yy6ZsQC9ZyecUB.gO91C'); -- 102030
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (1, 1);

INSERT INTO public.usuario(login, nome, senha) VALUES ('danielamartins', 'Daniela Martins', '$2a$10$umA2cp3zGaSMPAGreI3PKePL9eZaDcravDUIONL./dbk1g.LQS7hW'); -- 203040
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (2, 2);