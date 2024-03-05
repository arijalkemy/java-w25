-- Usar la base de datos
USE servicio_internet;

INSERT INTO cliente VALUES(1, "Luis", "Camacho", "1998-06-13", "California", "Bogota");
INSERT INTO cliente VALUES(2, "Mario", "Linares", "1998-12-13", "Cundinamarca", "Buenos Aires");
INSERT INTO cliente VALUES(3, "Luis", "Linares", "2001-07-15", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(4, "Luis", "Rodriguez", "2000-03-17", "California", "Buenos Aires");
INSERT INTO cliente VALUES(5, "Luis", "Pachon", "1996-05-25", "Cundinamarca", "Cali");
INSERT INTO cliente VALUES(6, "Lis", "Camaho", "1989-07-23", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(7, "Lus", "Caacho", "1987-11-19", "California", "Bogota");
INSERT INTO cliente VALUES(8, "Lis", "Camaho", "1978-08-14", "California", "Cali");
INSERT INTO cliente VALUES(9, "Luis", "Cmacho", "1989-03-22", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(10, "Lis", "Camcho", "1999-01-11", "Cundinamarca", "Cali");
INSERT INTO cliente VALUES(11, "Lus", "Aamacho", "1993-02-14", "Cundinamarca", "Bogota");

INSERT INTO plan_internet VALUES(1,1,"plan1",500,500.50,10);
INSERT INTO plan_internet VALUES(2,1,"plan2",500,500.50,10);
INSERT INTO plan_internet VALUES(3,4,"plan3",500,500.50,10);
INSERT INTO plan_internet VALUES(4,2,"plan1",500,500.50,10);
INSERT INTO plan_internet VALUES(5,5,"plan1",500,500.50,10);

SELECT * FROM cliente;


