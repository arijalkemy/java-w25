show tables;

create table cliente(
	clienteId int primary key auto_increment,
    dni varchar(256),
    nombre varchar(256),
    apellido varchar(256),
    fecha_nacimiento date,
    ciudad varchar(256),
    provincia varchar(256)
);
create table plan_internet(
		internet_id int primary key auto_increment,
        velocidad int,
        precio double,
        descuento double
);
create table internet_cliente(
	id int primary key auto_increment,
    cliente_id int,
    internet_id int,
    foreign key(cliente_id) references cliente(clienteId),
    foreign key(internet_id) references plan_internet(internet_id)
);

insert into cliente values(null,'43030815','agustin','sturba','2000-11-26','Buenos Aires','Buenos Aires');
insert into cliente values(2,'43030814','martin','sturba','2000-12-25','Buenos Aires','Buenos Aires');
insert into cliente values(3,'43030816','rodrigo','sturba','2000-10-25','Buenos Aires','Buenos Aires');
insert into cliente values(4,'43030817','roman','sturba','2001-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(5,'43030818','marcos','sturba','2002-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(6,'43030819','cristian','sturba','2003-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(7,'43030820','romero','sturba','2000-11-05','Buenos Aires','Buenos Aires');
insert into cliente values(8,'43030821','rayo','sturba','2010-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(9,'43030822','blondel','sturba','2009-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(10,'43030823','santiago','sturba','2000-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(11,'43030824','miguel','sturba','2000-09-23','Buenos Aires','Buenos Aires');

insert into plan_internet values(null,100,5500,10.5);
insert into plan_internet values(null,200,7850,12.5);
insert into plan_internet values(null,300,10500,13.5);
insert into plan_internet values(null,500,12500,14.5);
insert into plan_internet values(null,1000,15000,16.5);

insert into internet_cliente values(null,1,1);
insert into internet_cliente values(null,2,2);
insert into internet_cliente values(null,3,3);
insert into internet_cliente values(null,4,4);
insert into internet_cliente values(null,5,5);
insert into internet_cliente values(null,6,1);
insert into internet_cliente values(null,7,2);
insert into internet_cliente values(null,8,3);
insert into internet_cliente values(null,9,4);
insert into internet_cliente values(null,10,5);
insert into internet_cliente values(null,11,1);
insert into internet_cliente values(null,12,2);

select nombre from cliente;
select apellido from cliente;
select dni from cliente;
select * from plan_internet join (select * from cliente join internet_cliente on cliente.clienteId = internet_cliente.cliente_id) asociacion on plan_internet.internet_id=asociacion.internet_id