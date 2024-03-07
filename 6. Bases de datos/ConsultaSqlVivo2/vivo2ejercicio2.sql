create schema biblioteca;
use biblioteca;
#Creacion de la base y tablas
CREATE TABLE `biblioteca`.`autor` (
    `idAutor` INT NOT NULL,
    `nobre` VARCHAR(45) NULL,
    `nacionalidad` VARCHAR(45) NULL,
    PRIMARY KEY (`idAutor`)
);

CREATE TABLE `biblioteca`.`estudiante` (
    `idLector` INT NOT NULL,
    `nobre` VARCHAR(45) NULL,
    `apellido` VARCHAR(45) NULL,
    `direccion` VARCHAR(45) NULL,
    `carrera` VARCHAR(45) NULL,
    `edad` INT NULL,
    PRIMARY KEY (`idLector`)
);

CREATE TABLE `biblioteca`.`libro` (
    `idLibro` INT NOT NULL,
    `titulo` VARCHAR(45) NULL,
    `editorial` VARCHAR(45) NULL,
    `area` VARCHAR(45) NULL,
    PRIMARY KEY (`idLibro`)
);

CREATE TABLE `biblioteca`.`libroautor` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NULL,
  PRIMARY KEY (`idAutor`),
  INDEX `idLibro_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `idAutor`
    FOREIGN KEY (`idAutor`)
    REFERENCES `biblioteca`.`autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idLibro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
    CREATE TABLE `biblioteca`.`prestamo` (
  `idLector` INT NOT NULL,
  `idLibro` INT NOT NULL,
  `fechaPrestamo` DATE NULL,
  `fechaDevolucion` DATE NULL,
  `Devuelto` TINYINT NULL,
  PRIMARY KEY (`idLector`, `idLibro`),
  INDEX `idLibro_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `idLector`
    FOREIGN KEY (`idLector`)
    REFERENCES `biblioteca`.`estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idLibroPrestamo`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

insert into autor values (1,'Edgar','Inglés');
insert into autor values (2,'Tolkien','Inglés');
insert into autor values (3,'Octavio','Mexico');
insert into autor values (4,'Lovecraf','Irlandes');
insert into autor values (5,'Rowling','Ingles');


insert into libro values (1,'El cuervo','Global','Terror');
insert into libro values (2,'Corazon delator','Global','Terror');
insert into libro values (3,'Señor de los anillos 1','Universal','Fantasia');
insert into libro values (4,'Señor de los anillos 2','Universal','Fantasia');
insert into libro values (5,'Señor de los anillos 3','Universal','Fantasia');
insert into libro values (6,'100 años de soledad','Global','Ensayo');
insert into libro values (7,'Descenso del mal','Universal','Terror');
insert into libro values (8,'Harry Potter 1','Global','Fantasia');
insert into libro values (9,'Harry Potter 2','Global','Fantasia');
insert into libro values (10,'Harry Potter 3','Global','Fantasia');


insert into libroautor values (1,1);
insert into libroautor values (1,2);
insert into libroautor values (1,7);
insert into libroautor values (2,3);
insert into libroautor values (2,4);
insert into libroautor values (2,5);
insert into libroautor values (3,6);
insert into libroautor values (4,7);
insert into libroautor values (5,8);
insert into libroautor values (5,9);
insert into libroautor values (5,10);

insert into estudiante values (1,'Edgar','Medina','Chapultepec','Ingenieria en computacion',33);
insert into estudiante values (2,'Jacobed','Arias','Chapultepec','Medicina',27);
insert into estudiante values (3,'Hector','Ceron','Coyoacan','Ingenieria en computacion',34);
insert into estudiante values (4,'David','Mugica','Miquel Hidalgo','Ingenieria en computacion',34);
insert into estudiante values (5,'Farid','Martinez','Pachica','Ingenieria en computacion',28);
insert into estudiante values (6,'Ale','Orgel','Guadalara','Diseño Grafico',35);

insert into prestamo value (1,3, '2024-01-12', '2024-01-18',1);
insert into prestamo value (1,4, '2024-02-02', '2024-02-11',1);
insert into prestamo value (1,5, '2024-02-13', '2024-02-21',1);
insert into prestamo value (2,8, '2024-02-13', '2024-02-21',1);
insert into prestamo value (2,9, '2024-02-22', '2024-02-28',1);
insert into prestamo value (3,6, '2024-02-22', '2024-03-11',0);
insert into prestamo value (4,1, '2024-02-27', '2024-03-18',0);
insert into prestamo value (5,2, '2024-01-27', '2024-02-18',1);
insert into prestamo value (5,7, '2024-02-17', '2024-02-24',1);
insert into prestamo value (6,9, '2024-03-01', '2024-03-05',1);
insert into prestamo value (6,10, '2024-03-06', '2024-03-17',0);

#1 Listar autores
select * from autor;

#2 Listar estudiantes por nombre y edad
select nobre, edad from estudiante; 

#3 Estudiantes que pretenecen a ingenieria  en  computacion
select nobre, apellido from estudiante 
where estudiante.carrera = 'Ingenieria en computacion';

#4 Autores de nacionalidad mexico  e  ingles
select nobre from autor 
where autor.nacionalidad in ('Mexico','Inglés');

#5 Libros que no son del area de terror
select titulo from libro
where libro.area not in ('Terror');

#6 listado de libros de la editorial Global
select titulo from libro
where libro.editorial = 'Global';

#7 listar estudiante mayores al promedio
select nobre from estudiante
where edad > (select avg(edad)from estudiante);

#8 Listar estudiantes con letra inicial del apellido M
select nobre, apellido from estudiante
where apellido like 'M%';

#9 listar autores que escribieron 'Descenso del mal'
select a.nobre 
from libro l inner join libroautor la
on l.idLibro = la.idLibro
inner join autor a 
on a.idAutor = la.idAutor
where l.titulo = 'Descenso del mal'; 

#10 Libros que se prestaron a Edgar
select l.titulo
from prestamo p inner join estudiante e
on p.idLector = e.idLector
inner join libro l
on l.idLibro = p.idLibro
where e.nobre ='Edgar'; 

#11 Estudiante de menor edad
select nobre from estudiante
order by  edad asc
limit 1;

#11 Estudiante que les prestaron libros de fantasia
select distinct e.nobre 
from prestamo p inner join estudiante e
on p.idLector = e.idLector
inner join libro l
on l.idLibro = p.idLibro
where area='Fantasia';

#12 listar libros que le pertenecen a Rowling

select l.titulo
from libro l inner join libroautor la
on l.idLibro = la.idLibro
inner join autor a
on a.idAutor = la.idAutor
where a.nobre = 'Rowling';

#13 Listar libros que se deben entregar antes de 2024-03-01
select l.titulo 
from prestamo p inner join libro l
on p.idLibro = l.idLibro
where fechaDevolucion < '2024-03-01';


