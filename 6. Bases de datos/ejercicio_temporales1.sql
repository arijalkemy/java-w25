USE movies_db;
CREATE TEMPORARY TABLE TWD (
id INT NOT NULL PRIMARY KEY, 
created_at TIMESTAMP, 
updated_at TIMESTAMP, 
title VARCHAR(40), 
number INT, 
release_date DATE, 
rating FLOAT,
season_id INT NOT NULL)
SELECT e.* FROM episodes e
INNER JOIN seasons s
ON e.season_id = s.id
INNER JOIN series ser
ON ser.id = s.serie_id
WHERE ser.title LIKE "The Walking Dead";

select * from TWD 


