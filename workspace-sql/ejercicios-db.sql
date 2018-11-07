----EJERCICIOS
-- SOLO ES REQUERIDO REALIZAR LOS EJERCICIOS DE COMPLEJIDAD BAJA, realizar los demas ejercicios serán puntos extras para la evaluación del examen.


--- EJERCICIO 1 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todos los alumnos existentes, mostrar: TipoDoc, Documento, Nombre, Apellido, Legajo.
SELECT persona.TipoDoc, persona.documento, persona.nombre, persona.apellido, alumno.legajo
    FROM alumno, persona
    WHERE alumno.idpersona = persona.identificador;


--- EJERCICIO 2 - COMPLEJIDAD BAJA: 
--Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
--ordenado por legajo descendiente
SELECT alumno.legajo, persona.nombre, persona.apellido, carrera.nombre, inscar.fechainscripcion
    FROM inscripciones_carrera inscar 
	INNER JOIN carrera on inscar.idcarrera=carrera.identificador
	INNER JOIN alumno on inscar.idalumno=alumno.identificador
	INNER JOIN persona on alumno.idpersona=persona.identificador
    ORDER BY alumno.legajo desc;

--- EJERCICIO 3 - COMPLEJIDAD MEDIA: 
--Realizar una consulta para consultar la cantidad de inscriptos por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo máximo por curso
SELECT carrera.nombre, curso.nombre, count(*) as cantidadinscriptos, curso.cupomaximo
    FROM inscripciones_curso inscur
	LEFT JOIN curso on inscur.idcurso=curso.identificador
	LEFT JOIN carrera on curso.idcarrera=carrera.identificador	
	GROUP BY inscur.idcurso, carrera.nombre, curso.nombre, curso.cupomaximo;

--- EJERCICIO 4 - COMPLEJIDAD ALTA: 
--Sobre la consulta anterior (copiar y pegarla y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de inscripciones 
--supera su cupo maximo
SELECT carrera.nombre, curso.nombre, count(*) as cantidadinscriptos, curso.cupomaximo
    FROM inscripciones_curso inscur
	LEFT JOIN curso on inscur.idcurso=curso.identificador
	LEFT JOIN carrera on curso.idcarrera=carrera.identificador	
	GROUP BY inscur.idcurso, carrera.nombre, curso.nombre, curso.cupomaximo
	HAVING count(*) > curso.cupomaximo;

--- EJERCICIO 5 -  COMPLEJIDAD BAJA: 
-- actualizar todos las cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10.
UPDATE curso 
   SET cupomaximo=10
   WHERE curso.anio=2018 and curso.cupomaximo<5;


--- EJERCICIO 6 -  COMPLEJIDAD ALTA: 
-- actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
-- alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos, primero
-- realizando la consulta y luego realizando el update manual
UPDATE inscripciones_curso inscur
    SET fechainscripcion=current_date
    FROM inscripciones_carrera inscar
    WHERE inscur.idalumno=inscar.idalumno AND inscur.fechainscripcion<inscar.fechainscripcion;


--- EJERCICIO 7 - COMPLEJIDAD BAJA:  
--INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)
select * from persona;
select * from alumno;

INSERT INTO persona VALUES
    (6,'DNI', 28557372, 'Paula', 'Ciano', '1981-01-06');
INSERT INTO alumno VALUES
   (6,6, 55555);

--- EJERCICIO 8 -  COMPLEJIDAD BAJA: 
-- si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un único cambio string de 200 caracteres.
-- Determine sobre que tabla seria mas conveniente persistir esta información y realizar la modificación de estructuras correspondientes.
ALTER TABLE persona
   ADD COLUMN direccion varchar(200);
