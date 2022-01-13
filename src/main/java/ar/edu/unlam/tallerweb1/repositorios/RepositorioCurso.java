package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;

import java.util.List;

public interface RepositorioCurso {

    void agregarAlumnoAunCurso(Curso curso);

    void guardarCurso(Curso curso);

    void borrarCurso(Curso curso);

    void editarCurso(Curso curso);

    List<Curso> listarCurso();

    Curso buscarCursoPorId(Long id);

    List<Alumno> listarAlumnosDeUnCurso(Curso curso);

    void eliminarAlumnoDeCurso(Curso curso);
}
