delete from EstudianteEntity;
delete from TarjetaDeCreditoEntity;
delete from CalificacionEntity;
delete from FacturaEntity;

insert into EstudianteEntity (nombre, idMedioDePago, carrera, correo, calificacionPromedio, horarioDeTrabajo, semestre)
values ('David', 0, 'Sistemas', 'awdawd@uniandes.edu.co', 2.0, 'a', 4);

select * from EstudianteEntity;
delete from EstudianteEntity;