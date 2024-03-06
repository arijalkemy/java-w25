SELECT `movies`.`id`,
       `movies`.`created_at`,
       `movies`.`updated_at`,
       `movies`.`title`,
       `movies`.`rating`,
       `movies`.`awards`,
       `movies`.`release_date`,
       `movies`.`length`,
       `movies`.`genre_id`
FROM `movies_db`.`movies`;

SELECT first_name, last_name, rating from actors;
SELECT title as Titulo from series;
SELECT first_name as Nombre, last_name as Apellido from actors where rating > 7.5;
SELECT title as Pelicula, rating, awards as Premios from movies WHERE rating > 7.5 and awards > 2;
SELECT title as Pelicula, rating from movies ORDER BY rating;
SELECT title as Pelicula FROM movies LIMIT 3;
SELECT title as Pelicula, rating FROM movies ORDER BY rating DESC LIMIT 5;
SELECT first_name as Nombre, last_name as Apellido from actors LIMIT 10;
SELECT title as Pelicula, rating FROM movies WHERE title = 'Toy Story';
SELECT first_name as Nombre, last_name as Apellido FROM actors WHERE first_name LIKE 'Sam%';
SELECT title as Pelicula FROM movies WHERE release_date > '2004-01-01' and release_date < '2008-01-01';
SELECT title as Pelicula FROM movies WHERE rating > 3 and awards > 1 and release_date >= '1988-01-01' and release_date <= '2009-01-01' ORDER BY rating;

# A. La primary key para la tabla clientes es id_cliente, porque, se crea autoincrementable para evitar duplicidad en el campo
#	y asi asegurarnos que cada cliente tenga un ID unico y sea distinto

# B. La primary key para la tabla plan es id_plan, porque, se crea autoincrementable para evitar duplicidad en el campo
#	y asi asegurarnos que cada plan tenga un ID unico y sea distino

# C. Declaramos una relación de muchos a muchos, añadiendo una tabla intermedia "planXCliente", para establecer una relación de muchos a muchos, donde muchos clientes pueden tener muchos planes
# D. En la tabla intermedia

# E. El campo id_cliente, hace referencia a la tabla cliente al campo id_cliente, y el id_plan desde la tabla plan del campo id_plan