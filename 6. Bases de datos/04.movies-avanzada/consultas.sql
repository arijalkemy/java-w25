use movies_db;
-- Mostrar el título y el nombre del género de todas las series.
select title as 'Título', g.name as 'Género'  from series s
	inner join genres g on g.id = s.genre_id;
    
-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
select s.title as 'Serie', se.title 'Temporada', e.title 'Episodio', concat(a.first_name,' ',a.last_name) as 'Actor' from series s
	inner join seasons se on s.id = se.serie_id
    inner join episodes e on e.season_id = se.id
    inner join actor_episode ae on e.id = ae.episode_id
    inner join actors a on a.id = ae.actor_id
group by s.title, se.title, e.title, a.first_name, a.last_name;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
select s.title as 'Serie', count(distinct se.id) from series s
	inner join seasons se on s.id = se.serie_id
group by s.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
select g.name as 'Género', count(m.id) as cantidad from genres g
	inner join movies m on g.id = m.genre_id
group by g.id
having cantidad >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
select a.first_name as 'Nombre', a.last_name as 'Apellido' from movies m
	inner join actor_movie ma on m.id = ma.movie_id
    inner join actors a on a.id = ma.actor_id
where m.title like '%Guerra de las galaxias%'
group by a.first_name, a.last_name;