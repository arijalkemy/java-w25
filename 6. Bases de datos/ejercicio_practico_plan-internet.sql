use internet_db;


CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    province VARCHAR(50),
    city VARCHAR(50)
);

CREATE TABLE planes (
    id INT PRIMARY KEY,
    speed INT NOT NULL,
    price FLOAT NOT NULL,
    discount INT NOT NULL
);

#Ejercicio 2
#Primary key es el id del cliente en lugar del DNI. La responsabilidad de identificar
#un registro debería recaer sobre la db y no en el registro en sí.

#Primary key es el id del plan. La responsabilidad de identificar
#un registro debería recaer sobre la db y no en el registro en sí.
#En este caso identificamos que el id de la entidad independiente no puede ser autoincrementable.

#Al haber una relacion 1:N la clave fóranea se ubicará en la entidad cliente. Su nombre será plan_id
#y hará referencia a el id del plan.

#Ejercicio 3
INSERT INTO planes (id, speed, price, discount)
VALUES
  ('1', 30, 29.99, 5),
  ('2', 50, 39.99, 10),
  ('3', 100, 49.99, 15),
  ('4', 200, 59.99, 20),
  ('5', 500, 79.99, 25);
  
ALTER TABLE clientes
ADD COLUMN plan_id int;

  
ALTER TABLE clientes
ADD CONSTRAINT fk_planes
FOREIGN KEY (plan_id)
REFERENCES planes (id);

INSERT INTO clientes (dni, first_name, last_name, birth_date, province, city, plan_id)
VALUES
  ('123456789', 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires', 1),
  ('987654321', 'María', 'Gómez', '1985-05-20', 'Córdoba', 'Córdoba', 3),
  ('567890123', 'Carlos', 'Rodríguez', '1988-11-08', 'Mendoza', 'Mendoza', 5),
  ('345678901', 'Laura', 'Fernández', '1995-03-25', 'Santa Fe', 'Rosario', 2),
  ('789012345', 'Pedro', 'Martínez', '1980-09-10', 'Tucumán', 'San Miguel de Tucumán', 3),
  ('234567890', 'Ana', 'López', '1992-07-18', 'Salta', 'Salta', 1),
  ('456789012', 'Diego', 'Sánchez', '1983-12-30', 'Entre Ríos', 'Paraná', 1),
  ('890123456', 'Carmen', 'García', '1998-06-05', 'Buenos Aires', 'La Plata' ,1),
  ('012345678', 'Jorge', 'Ramírez', '1982-04-12', 'Neuquén', 'Neuquén', 1),
  ('678901234', 'Silvia', 'Díaz', '1993-08-28', 'San Juan', 'San Juan', 1);
  
  
  #Ejercicio 4
  SELECT * FROM clientes inner join planes on clientes.plan_id = planes.id;
  
  SELECT * FROM clientes where province LIKE '%Buenos Aires%'

