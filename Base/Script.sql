create database integradorCaC;
use integradorCaC;

create table alumnos(
	id_alumno int not null auto_increment,
    nombre varchar(30),
    apellido varchar(30),
    dni int not null unique,
    mail varchar(30),
    
    primary key(id_alumno)
);

insert into alumnos values (1, 'Julieta', 'Rey', 41023698, 'jrey@gmail.com');
insert into alumnos values (2, 'Agustín', 'Piche', 39256487, 'apiche@gmail.com');
insert into alumnos values (3, 'Darelis', 'Quinto', 95036214, 'dquinto@gmail.com');
insert into alumnos values (4, 'Sofía', 'Schiavi', 41532641, 'sschiavi@gmail.com');
insert into alumnos values (5, 'Ana Lucía', 'Vidal', 41023698, 'alvidal@gmail.com');
insert into alumnos values (6, 'Benjamín', 'Céspedes', 42003654, 'bcespedes@gmail.com');
insert into alumnos values (7, 'Nicolás', 'Jofre', 42015698, 'njofre@gmail.com');
insert into alumnos values (8, 'Tomás', 'Fernández', 40025874, 'tfernandez@gmail.com');
insert into alumnos values (9, 'Rocío', 'Canale', 42541789, 'rcanale@gmail.com');
insert into alumnos values (10, 'Candela', 'López', 39987456, 'clopez@gmail.com');

insert into alumnos values (5, 'Ana Lucía', 'Vidal', 94236541, 'alvidal@gmail.com');

select * from alumnos