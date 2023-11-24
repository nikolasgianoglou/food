insert into cozinha (id, nome) values (1, 'Tailandesa')
insert into cozinha (id, nome) values (2, 'Indiana')

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Deivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into estado (id, nome) values (1, 'Minas Gerais')
insert into estado (id, nome) values (2, 'São Paulo')
insert into estado (id, nome) values (3, 'Goiás')
insert into estado (id, nome) values (4, 'Pernambuco')
insert into estado (id, nome) values (5, 'Pará')

insert into forma_pagamento (descricao) values ('DEBITO');
insert into forma_pagamento (descricao) values ('CREDITO');