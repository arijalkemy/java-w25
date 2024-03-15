create table cliente(
	cliente_id int primary key auto_increment,
    dni varchar(256),
    nombre varchar(256),
    apellido varchar(256),
    fecha_nacimiento date,
    provincia varchar(256),
    ciudad varchar(256)
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
    foreign key (cliente_id) references cliente(cliente_id),
    foreign key (internet_id) references plan_internet(internet_id)
);

insert into cliente values(null,'43030815','agustin','sturba','2000-11-26','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030814','martin','lopez','2000-12-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030816','rodrigo','gomez','2000-10-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030817','roman','fernandez','2001-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030818','marcos','juarez','2002-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030819','cristian','piccoli','2003-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030820','romero','unali','2000-11-05','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030821','agustin','palermo','2010-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030822','blondel','fuertes','2009-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030823','santiago','lopez','2000-11-25','Buenos Aires','Buenos Aires');
insert into cliente values(null,'43030824','miguel','pozo','2000-09-23','Buenos Aires','Buenos Aires');

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

#mostrar todos los clientes
select * from cliente;

#mostrar todos los planes de internet
select * from plan_internet;

#mostrar todos los clientes con el nombre agustin
select * from cliente where nombre like "agustin";

#mostrar los clientes que nacieron desde el 2002
select * from cliente where fecha_nacimiento between "2002-01-01" and curdate();

#mostrar todos los clientes que tengan el servicio de 100mb
select c.nombre, c.apellido, c.dni, p.velocidad, p.precio, p.descuento
						from cliente c join internet_cliente ic on c.cliente_id = ic.cliente_id
						join plan_internet p on p.internet_id = ic.internet_id
						where p.velocidad = 100;

#mostrar el nombre y apellido de todos los clientes y el precio final del plan adherido
select c.nombre, c.apellido, p.precio - (p.precio*(p.descuento/100)) as "precio final"
	from cliente c join internet_cliente ic on c.cliente_id = ic.cliente_id
    join plan_internet p on p.internet_id = ic.internet_id;
    
#mostrar la suma del precio final de todos los planes
select sum(p.precio - (p.precio*(p.descuento/100))) as "total" 
from plan_internet p;

#mostrar todos los planes que tenga el cliente que se llama santiago
select c.nombre, c.apellido, p.velocidad, p.precio, p.descuento from cliente c
	join internet_cliente ic on c.cliente_id = ic.cliente_id
    join plan_internet p on p.internet_id = ic.internet_id
    where c.nombre like "santiago";
    
#mostrar todas las columnas de las tablas
select * from cliente c join internet_cliente ic on c.cliente_id = ic.cliente_id
	join plan_internet p on p.internet_id = ic.internet_id;
    
#mostrar la cantidad de clientes
select count(*) from cliente c;