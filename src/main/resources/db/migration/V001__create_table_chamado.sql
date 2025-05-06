create table chamado (
    id bigint not null auto_increment,
    descricao varchar(255),
    rua varchar(255),
    numero varchar(255),
    bairro varchar(255),
    cidade varchar(255),
    data_abertura datetime(6),
    data_resolucao datetime(6),
    status_atual enum ('ABERTO','EM_ANDAMENTO','RESOLVIDO'),
    comentario_servidor varchar(255),
    descricao_tipo varchar(255),
    primary key (id)
) engine=InnoDB;
