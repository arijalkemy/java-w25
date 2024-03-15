# Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
create temporary table TWD (title varchar(100), season int);

insert into TWD select e.title, s.number from episodes e join seasons s on e.season_id = s.id 
join series s2 on s.serie_id = s2.id
where s2.title like 'The Walking Dead';

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from TWD;

# Seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
select * from movies where awards < 3;
create index indice_awards on movies (awards);
show index from movies;
# Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
# RTA: porque es un campo que se puede llegar a usar con frecuencia.