package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;

import java.util.List;

public interface ServicioCurso {

    void guardarCurso(Curso curso);
    void borrarCurso(Curso curso);
    void editarCurso(Curso curso);
    void agregarAlumnoAUnCurso(Curso curso , Alumno alumno) ;
    List<Curso> listaDeCursos();

    Curso buscarCursoPorId(Long id);

    List<Alumno> listaDeAlumnosDeUnCurso(Curso curso);

    void eliminarAlumnoDeCurso(Alumno alumno, Curso curso);
}
