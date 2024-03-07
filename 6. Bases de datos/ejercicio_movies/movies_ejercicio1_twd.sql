USE movies_db;
CREATE INDEX series_title ON series(title);
SHOW INDEX FROM series;

DROP  TABLE IF EXISTS twd;

CREATE TEMPORARY TABLE TWD (id_episode INT, title VARCHAR(500), rating decimal(3,1),season_number INT,  season_description varchar(500) );

INSERT INTO TWD SELECT e.id, e.title, e.rating,s.number, s.title FROM episodes e  
INNER JOIN seasons s on s.id  = e.season_id 
INNER JOIN series s2 on s2.id = s.serie_id 
WHERE s2.title  = "The Walking Dead";

SELECT * FROM TWD WHERE season_number = 1;  
