package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;

import java.util.List;

public interface ServicioAlumno {

    void registrarAlumno(Alumno alumno);
    List<Alumno> listarAlumnos();

    void borrarAlumno(Alumno alumno);

    Alumno buscarAlumnoPorID(Long id);

    void editarAlumno(Alumno alumno);



}
