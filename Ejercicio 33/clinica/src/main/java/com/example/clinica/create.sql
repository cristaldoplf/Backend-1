DROP TABLE IF EXISTS domicilio;
DROP TABLE IF EXISTS paciente;
DROP TABLE IF EXISTS odontologo;
DROP TABLE IF EXISTS turno;
create table IF NOT EXISTS odontologo(ID int primary key NOT NULL AUTO_INCREMENT, APELLIDO varchar (255), NOMBRE varchar (255), MATRICULA varchar (255));
create table IF NOT EXISTS domicilio(ID int primary key NOT NULL AUTO_INCREMENT, CALLE varchar (255), NUMERO varchar (255), LOCALIDAD varchar (255), PROVINCIA varchar (255));
create table IF NOT EXISTS paciente(id INT primary key NOT NULL AUTO_INCREMENT,apellido VARCHAR (255), nombre VARCHAR (255), email VARCHAR (255), DNI int, fechaIngreso DATE, domicilioId INT);
create table IF NOT EXISTS turno(ID int primary key NOT NULL AUTO_INCREMENT, fecha DATE, odontologoId int, pacienteId int);