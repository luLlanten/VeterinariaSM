create table user (
    user_id INTEGER not null AUTO_INCREMENT,
    nombre  varchar(30) NOT NULL,
    apellido varchar(30) NOT NULL,
    tipo BOOLEAN not NULL,
    activo BOOLEAN NOT NULL,
    direccion VARCHAR(100) not NULL,
    telefono INT(8) not null,
    fecha_ingreso DATE NOT NULL,
    correo VARCHAR(100) not null UNIQUE,
    contrasena VARCHAR(16) NOT NULL,
    PRIMARY KEY(user_id)
)

create table admin(
    admin_id INTEGER not null auto_increment,
    nombre VARCHAR(30) not null,
    apellido VARCHAR(30) not NULL,
    telefono INTEGER(8) not null,
    fecha_ingreso DATE not null,
    correo VARCHAR(16) not null,
    activo BOOLEAN not null,
    PRIMARY KEY(admin_id)
)