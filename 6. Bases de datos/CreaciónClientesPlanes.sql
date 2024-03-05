USE empresa_internet;

INSERT INTO Clientes values (123,"Pedro","Gonzales","1997-01-01","Bogota","Bogota");
INSERT INTO Clientes values (456,"Maria","Perez","1989-01-01","Medellin","Medellin");
INSERT INTO Clientes values (789,"Angelica","Rojas","2000-01-01","Buenos Aires","Buenos Aires");
INSERT INTO Clientes values (111,"Sergio","Gonzales","1992-01-01","Cordoba","Cordoba");
INSERT INTO Clientes values (222,"Paola","Marquez","1975-01-01","Bogota","Bogota");
SELECT * FROM empresa_internet.Clientes;

INSERT INTO Planes values (1,100, 400, 5,222);
INSERT INTO Planes values (5,500, 100, 10,111);
INSERT INTO Planes values (20,100, 400, 10,123);
INSERT INTO Planes values (30,100, 400, 7,789);
INSERT INTO Planes values (40,100, 400, 5,4569);
SELECT * FROM empresa_internet.Planes;

/**/