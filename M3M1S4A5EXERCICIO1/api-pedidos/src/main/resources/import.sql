INSERT INTO public.cliente(cpf, nome, rg) VALUES ('000.000.000-00', 'Gilmar', '123456');
INSERT INTO public.cliente(cpf, nome, rg) VALUES ('000.000.000-01', 'Patrícia', '1234567');

INSERT INTO public.forma_pagamento(descricao) VALUES ('Débito');
INSERT INTO public.forma_pagamento(descricao) VALUES ('Crédito');


INSERT INTO public.produto(data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES ('01/01/2022', '02/01/2022', 'Pizza de Frango', 5.9, 9.99);
INSERT INTO public.produto(data_hora_alteracao, data_hora_cadastro, descricao, preco_compra, preco_venda) VALUES ('01/09/2022', '10/01/2022', 'Pizza de Mussarela', 6.9, 11.99);
