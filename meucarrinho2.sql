/**
* Atividade de avaliação - Banco de dados
* Projeto 3: Carrinho de compras
* Versão 1.0
* @author Jonathan Santos
**/

create database dbkasper;
use dbkasper;

create table meucarrinho (
	idpro int primary key auto_increment,
    produto varchar(100) not null,
    valor int not null,
    quantidade decimal(10,2) not null
);

describe meucarrinho;

insert into meucarrinho (produto,quantidade,valor)
values
('Sulfite',1,'14.99');
insert into meucarrinho (produto,quantidade,valor)
values
('Roteador Tp-Link',1,'286.21');
insert into meucarrinho (produto,quantidade,valor)
values
('PenDrive 128GB',1,'118.36');


select * from meucarrinho;
select * from carrinho where codigo = 1;
select * from carrinho order by produto;
select sum(valor*quantidade) as Total from carrinho;

update meucarrinho set produto='Sulfite' where idpro=1;

delete from meucarrinho where idpro=7;