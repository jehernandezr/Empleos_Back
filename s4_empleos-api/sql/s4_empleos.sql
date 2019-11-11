
--insert into EstudianteEntity (id, nombre, idMedioDepago, carrera, correo, calificacionPromedio, horarioDeTrabajo, semestre) values(1, 'David', 1, 'Sistemas', 'algo@uniandes.edu.co', 2, 'a', 4);
insert into ContratistaEntity (id, contrasena, email, esExterno, rutaImagen) values(20, 'Dsdf', 'dsa@hotmail.com', 'true','dsfs');
SELECT * FROM COntratistaEntity
SELECT * FROM CuentaDeCobroEntity;
delete from EstudianteEntity;
delete from TarjetaDeCreditoEntity;
delete from CalificacionEntity;
delete from FacturaEntity;

delete from EstudianteEntity;

insert into CuentaDeCobroEntity (numeroCuentaDeCobro,contratista,fecha, valor,nombreEstudiante,concepto)
values(1,null,null,23,'benito','f');
insert into EstudianteEntity (nombre, idMedioDePago, carrera, correo, calificacionPromedio, horarioDeTrabajo, semestre)
values ('David', 0, 'Sistemas', 'awdawd@uniandes.edu.co', 2.0, 'a', 4);
