use empresa_internet_db;

select nombre, apellido from cliente;

select nombre, apellido, fecha_nacimiento from cliente
where year(fecha_nacimiento) > 1990;

select provincia, ciudad, count(distinct id) from cliente
group by provincia, ciudad;

select c.nombre, c.apellido, p.velocidad as 'velocidad contratada', cp.precio from cliente_planes_internet cp 
	inner join cliente c on cp.cliente_id = c.id
    inner join planes_internet p on cp.plan_id = p.id
group by c.id, p.id;