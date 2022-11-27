INSERT INTO public.cliente(cpf, nome, rg) VALUES ('00000000000', 'Pedro', '123456');
INSERT INTO public.cliente(cpf, nome, rg) VALUES ('00000000001', 'Paulo', '1234567');
INSERT INTO public.cliente(cpf, nome, rg) VALUES ('00000000003', 'João', '12345678');

INSERT INTO public.forma_pagamento(descricao) VALUES ('Débito');
INSERT INTO public.forma_pagamento(descricao) VALUES ('Crédito');

INSERT INTO public.produto(data_hora_alteracao, data_hora_cadastro, decricao_reduzida, descricao, preco_compra, preco_venda) VALUES ('01-01-1970', '02-01-1970', 'Pizza', 'Pizza de Frango', 4, 9.88);
INSERT INTO public.produto(data_hora_alteracao, data_hora_cadastro, decricao_reduzida, descricao, preco_compra, preco_venda) VALUES ('01-01-1970', '02-01-1970', 'Lasanha', 'Lasanha 4 Queijos', 4, 9.88);

INSERT INTO public.pedido(data_hora_alteracao, data_hora_cadastro, id_cliente, id_forma_pagamento) VALUES ('01-01-2022', '02-01-2022', 2, 2);
INSERT INTO public.pedido(data_hora_alteracao, data_hora_cadastro, id_cliente, id_forma_pagamento) VALUES ('05-01-2022', '06-01-2022', 1, 1);

INSERT INTO public.item_pedido(quantidade, valor_item, id_pedido, id_produto) VALUES ( 10, 20, 1, 1);
INSERT INTO public.item_pedido(quantidade, valor_item, id_pedido, id_produto) VALUES ( 10, 20, 2, 2);
