package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioAlumno")
@Transactional
public class ServicioAlumnoImpl implements ServicioAlumno{
    private RepositorioAlumno repositorioAlumno;

    @Autowired
    public ServicioAlumnoImpl(RepositorioAlumno repositorioAlumno) {
        this.repositorioAlumno = repositorioAlumno;
    }

    @Override
    public void registrarAlumno(Alumno alumno) {
        repositorioAlumno.guardar(alumno);
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return repositorioAlumno.listarAlumnos();
    }

    @Override
    public void borrarAlumno(Alumno alumno) {
        repositorioAlumno.borrarAlumno(alumno);
    }

    @Override
    public Alumno buscarAlumnoPorID(Long id) {
        return repositorioAlumno.buscarAlumnoPorId(id);
    }

    @Override
    public void editarAlumno(Alumno alumno) {
        repositorioAlumno.editarAlumno(alumno);
    }



}
