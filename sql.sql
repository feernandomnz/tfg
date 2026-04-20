CREATE DATABASE ocupaciones;

USE ocupaciones;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    rol VARCHAR(50)
);

INSERT INTO usuarios (nombre, email, password, rol)
VALUES ('Juan', 'juan@mail.com', '123', 'admin'),
       ('Ana', 'ana@mail.com', '123', 'user');

CREATE TABLE propiedades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    direccion VARCHAR(200),
    ciudad VARCHAR(100),
    propietario_id INT,
    FOREIGN KEY (propietario_id) REFERENCES usuarios(id)
);

INSERT INTO propiedades (direccion, ciudad, propietario_id)
VALUES ('Calle Falsa 123', 'Madrid', 1),
       ('Av. Siempre Viva 456', 'Barcelona', 2);
       
CREATE TABLE incidencias (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(100),
    descripcion TEXT,
    fecha DATETIME,
    prioridad VARCHAR(50),
    propiedad_id INT,
    FOREIGN KEY (propiedad_id) REFERENCES propiedades(id)
);

INSERT INTO incidencias (tipo, descripcion, fecha, prioridad, propiedad_id)
VALUES ('Ocupación sospechosa', 'Se detectó movimiento extraño', NOW(), 'Alta', 1);

CREATE DATABASE IF NOT EXISTS ocupaciones;
USE ocupaciones;

-- Datos de prueba para usuarios
INSERT INTO usuarios (nombre, email, password, rol)
VALUES ('Admin','admin@tfg.com','1234','ADMIN');