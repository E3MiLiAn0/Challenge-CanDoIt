package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("servicioCurso")
@Transactional
public class ServicioCursoImpl implements ServicioCurso {
    RepositorioCurso repositorioCurso;

    @Autowired
    public ServicioCursoImpl(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    @Override
    public void guardarCurso(Curso curso) {
        repositorioCurso.guardarCurso(curso);
    }

    @Override
    public void borrarCurso(Curso curso) {
        repositorioCurso.borrarCurso(curso);

    }

    @Override
    public void editarCurso(Curso curso) {
        repositorioCurso.editarCurso(curso);
    }

    @Override
    public void agregarAlumnoAUnCurso(Curso curso, Alumno alumno)  {
       List<Alumno> alumnosEnCurso= curso.getAlumnos();
       alumnosEnCurso.add(alumno);
       curso.setAlumnos(alumnosEnCurso);
       repositorioCurso.agregarAlumnoAunCurso(curso);

    }

    @Override
    public List<Curso> listaDeCursos() {

        return repositorioCurso.listarCurso();
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        return repositorioCurso.buscarCursoPorId(id);
    }

    @Override
    public List<Alumno> listaDeAlumnosDeUnCurso(Curso curso) {
        return repositorioCurso.listarAlumnosDeUnCurso(curso);
    }

    @Override
    public void eliminarAlumnoDeCurso(Alumno alumno, Curso curso) {
        List<Alumno> alumnosEnElCurso= curso.getAlumnos();
        List<Alumno> nuevaListaDeAlumnos = new ArrayList<>();

        for (Alumno alumno1 : alumnosEnElCurso){
            if(alumno1.getId()!= alumno.getId()){
                nuevaListaDeAlumnos.add(alumno1);
            }
        }
        alumnosEnElCurso.remove(alumno);
        curso.setAlumnos(nuevaListaDeAlumnos);
        repositorioCurso.eliminarAlumnoDeCurso(curso);

    }
}
