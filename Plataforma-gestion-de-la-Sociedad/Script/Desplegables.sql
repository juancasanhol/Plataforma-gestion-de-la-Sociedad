USE sociedad;
CREATE TABLE Tipo_documento_identificativo  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Sexo 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Pais_origen 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Nacionalidad  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Minoria_etnica 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Tipo_discapacidad 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Grado_discapacidad  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Tipo_carnet_conducir  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Otros_carnets
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Profesion  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Situacion_laboral  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Bolsa_trabajo  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Nivel_estudios 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Origen_ingresos  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Motivo_coste 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Relacion_con_titular  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Tipo_servicio  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Tipo_curso
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Empresa_practicas  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Procedencia_derivacion  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Motivo_consulta
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Intervencion  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Estado_resolucion 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Ayuda_general
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Ayuda_recibos  
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Ayuda_asistencia_sanitaria 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Otras_ayudas 
   (nombre varchar(30) PRIMARY KEY NOT NULL);
CREATE TABLE Alimento 
   (nombre varchar(30) PRIMARY KEY NOT NULL);

