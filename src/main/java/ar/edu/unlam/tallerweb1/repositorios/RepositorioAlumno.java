package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;

import java.util.List;

public interface RepositorioAlumno {
    void guardar(Alumno alumno);

    List<Alumno> listarAlumnos();

    void borrarAlumno(Alumno alumno);

    Alumno buscarAlumnoPorId(Long id);

    void editarAlumno(Alumno alumno);



}
