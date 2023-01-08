create database Practica2;
use Practica2;

  create table Categoria(
    idCategoria int not null auto_increment primary key,
    nombreCategoria varchar(50) not null,
    descripcion varchar(250) not null);

  insert into Categoria(nombreCategoria, descripcion) values ("Computacion", "Articulos de computacion");