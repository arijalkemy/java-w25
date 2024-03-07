DROP TEMPORARY TABLE twd; 
 
CREATE TEMPORARY TABLE twd (
 	id int(10),
 	title varchar(500),
 	number int(10),
 	rating decimal(3,1),
 	season_title varchar(500)
);

INSERT INTO twd (select 
e.id,
e.title,
e.`number`,
e.rating,
s.title
from movies m 
inner join actor_movie am on am.movie_id = m.id
inner join actors a on a.id = am.actor_id 
inner join actor_episode ae on ae.actor_id = a.id 
inner join episodes e ON e.id = ae.episode_id
inner join seasons s on s.id = e.season_id
)

SELECT 
* 
FROM twd;

SELECT 
* 
FROM twd 
where season_title = 'Primer Temporada';

