drop table if exists ventas;
drop table if exists productos;
drop table if exists cajeros;
drop table if exists maquinas_registradoras;

create table productos(
	codigo int auto_increment,
    nombre varchar(100),
    precio int,
    primary key(codigo)
);

create table cajeros(
	codigo int auto_increment,
    nombre_apels varchar(255),
    primary key(codigo)
);

create table maquinas_registradoras(
	codigo int auto_increment,
    piso int,
    primary key(codigo)
);

create table ventas(
	id int auto_increment,
	codigo_producto int not null,
	codigo_cajero int not null,
	codigo_maquina_registradora int not null,
    primary key(id),
    constraint fk_productos_ventas foreign key (codigo_producto)
    references productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    constraint fk_cajeros_ventas foreign key (codigo_cajero)
    references cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint fk_maquinas_registradoras_ventas foreign key (codigo_maquina_registradora)
    references  maquinas_registradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into productos(nombre, precio)values ('producto1', 5),('producto2', 2),('producto3', 6),('producto4', 1),('producto5', 3);
insert into cajeros(nombre_apels)values ('cajero1'),('cajero2'),('cajero3'),('cajero4'),('cajero5');
insert into maquinas_registradoras(piso)values (1),(1),(2),(3);
insert into ventas(codigo_producto,codigo_cajero,codigo_maquina_registradora)values (1,2,1),(2,2,1),(3,4,2),(4,5,4),(5,1,3);