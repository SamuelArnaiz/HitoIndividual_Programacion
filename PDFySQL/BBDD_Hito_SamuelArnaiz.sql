drop database if exists hito;
create database hito;
use hito;

CREATE TABLE productos(
	idProducto int Primary Key auto_increment,
    nombre varchar(20),
    fechaEnvasado Date,
    unidades int,
    precio float,
    disponible boolean
);

INSERT INTO productos VALUES
(null,'Atun',"2022-05-27",400,4.8,true);

Select * from productos;