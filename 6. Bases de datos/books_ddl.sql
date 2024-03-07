CREATE TABLE IF NOT EXISTS authors(
	id integer AUTO_INCREMENT,
	name varchar(50) not null,
	nationality varchar(50) not null
);

ALTER TABLE authors ADD CONSTRAINT authors_pk PRIMARY KEY(id);

CREATE TABLE IF NOT EXISTS students(
	id integer AUTO_INCREMENT,
	name varchar(50) not null,
	last_name varchar(50) not null,
	address varchar(100) not null,
	career varchar(30) not null,
	age integer not null
);

ALTER TABLE students ADD CONSTRAINT students_pk PRIMARY KEY(id);

CREATE TABLE IF NOT EXISTS books(
	id integer AUTO_INCREMENT,
	name varchar(100) not null,
	editorial text not null,
	area varchar(50) not null
);

ALTER TABLE books ADD CONSTRAINT books_pk PRIMARY KEY (id);


CREATE TABLE IF NOT EXISTS book_authors(
	id integer AUTO_INCREMENT,
	author_id integer not null,
	book_id integer not null
);

ALTER TABLE book_authors ADD CONSTRAINT book_authors_pk  PRIMARY KEY(id);
ALTER TABLE book_authors ADD CONSTRAINT book_authors_author_id_fk 
	FOREIGN KEY(author_id) REFERENCES authors(id);
ALTER TABLE book_authors ADD CONSTRAINT book_authors_book_id_fk 
	FOREIGN KEY(book_id) REFERENCES books(id);
