
# Evolución de la Tabla a través de las Formas Normales

## Tabla Inicial
La tabla inicial combina facturas y detalles de artículos en una sola estructura.
```sql
CREATE TABLE facturas (
    idFactura INT PRIMARY KEY AUTO_INCREMENT,
    fecha_factura DATE NOT NULL,
    forma_pago DECIMAL(10,0) NOT NULL,
    iva DECIMAL(10,0) NOT NULL,
    cantidad INT NOT NULL,
    importe DECIMAL(10,0) NOT NULL,
    nombre_cliente VARCHAR(100) NOT NULL,
    apellido_cliente VARCHAR(100) NOT NULL,
    direccion_cliente VARCHAR(100) NOT NULL,
    descripcion_articulo VARCHAR(100) NOT NULL
);
```

## Aplicación de la 1NF (Primera Forma Normal)
**Objetivo**: Separar datos para asegurar valores atómicos y mantener la consistencia de tipos.
- **Cambios**:
  - Se separan los datos de factura y artículo en dos tablas.
- **Resultado**:
```sql
CREATE TABLE Facturas (
    idFactura INT PRIMARY KEY AUTO_INCREMENT,
    fecha_factura DATE NOT NULL,
    forma_pago DECIMAL(10,0) NOT NULL,
    iva DECIMAL(10,0) NOT NULL
);

CREATE TABLE Articulos (
    idArticulo INT PRIMARY KEY AUTO_INCREMENT,
    descripcion_articulo VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    importe DECIMAL(10,0) NOT NULL
);
```

## Aplicación de la 2NF (Segunda Forma Normal)
**Objetivo**: Asegurar que todos los datos dependan completamente de la clave primaria.
- **Cambios**:
  - Se introduce una clave foránea en `Articulos` para vincular con `Facturas`.
- **Resultado**:
```sql
CREATE TABLE Facturas (
    idFactura INT PRIMARY KEY AUTO_INCREMENT,
    fecha_factura DATE NOT NULL,
    forma_pago DECIMAL(10,0) NOT NULL,
    iva DECIMAL(10,0) NOT NULL
);

CREATE TABLE ArticulosFactura (
    idArticuloFactura INT PRIMARY KEY AUTO_INCREMENT,
    idFactura INT,
    descripcion_articulo VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    importe DECIMAL(10,0) NOT NULL,
    FOREIGN KEY (idFactura) REFERENCES Facturas(idFactura) ON DELETE CASCADE
);
```

## Aplicación de la 3NF (Tercera Forma Normal)
**Objetivo**: Eliminar dependencias transitivas para reducir redundancia.
- **Cambios**:
  - Se extraen los datos del cliente a su propia tabla para evitar redundancia.
- **Resultado**:
```sql
CREATE TABLE Clientes (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL
);

CREATE TABLE Facturas (
    idFactura INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    forma_pago DECIMAL(10,0) NOT NULL,
    iva DECIMAL(10,0) NOT NULL,
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Clientes(idCliente)
);

CREATE TABLE ArticulosFactura (
    idArticuloFactura INT PRIMARY KEY AUTO_INCREMENT,
    idFactura INT,
    descripcion_articulo VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    importe DECIMAL(10,0) NOT NULL,
    FOREIGN KEY (idFactura) REFERENCES Facturas(idFactura) ON DELETE CASCADE
);
```