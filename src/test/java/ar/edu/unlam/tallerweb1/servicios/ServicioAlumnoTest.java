package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlumno;
import org.junit.Test;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioAlumnoTest {

    private RepositorioAlumno repositorioAlumno= mock(RepositorioAlumno.class);
    private ServicioAlumno servicioAlumno= new ServicioAlumnoImpl(repositorioAlumno);

    @Test
    public void registrarAlumno(){
        Alumno alumno=givenUnAlumno();
        whenRegistroUnAlumno(alumno);
        thenVerificarQueSeLLamoAlMetodoSaveDelRepositorio();
    }

    @Test
    public void borrarAlumno(){
        Alumno alumno=givenUnAlumno();
        whenBorroUnAlumno(alumno);
        thenVerificarQueSeLLamoAlMetodoBorrarDelRepositorio();
    }
    @Test
    public void buscarAlumnoporId(){
        givenUnAlumnoQueExite(1l);
       Alumno alumno= whenBuscoUnAlumno(1l);
        thenVerficarQueSeObtuvoUnAlumno(alumno);
    }

    private void thenVerficarQueSeObtuvoUnAlumno(Alumno alumno) {
        assertThat(alumno.getId()).isEqualTo(1l);
    }

    private Alumno whenBuscoUnAlumno(long l) {
       return servicioAlumno.buscarAlumnoPorID(l);
    }

    private void givenUnAlumnoQueExite(Long id) {
        Alumno alumno= new Alumno();
        alumno.setId(1l);
        when(repositorioAlumno.buscarAlumnoPorId(id)).thenReturn(alumno);
    }

    private void whenBorroUnAlumno(Alumno alumno) {
        servicioAlumno.borrarAlumno(alumno);
    }

    private void thenVerificarQueSeLLamoAlMetodoBorrarDelRepositorio() {
        verify(repositorioAlumno,times(1)).borrarAlumno(anyObject());

    }

    private Alumno givenUnAlumno() {
        Alumno alumno= new Alumno();
        alumno.setNombre("emiliano");
        alumno.setId(1l);
        alumno.setApellido("ovejero");
        return alumno;
    }

    private void whenRegistroUnAlumno(Alumno alumno) {
        servicioAlumno.registrarAlumno(alumno);
    }

    private void thenVerificarQueSeLLamoAlMetodoSaveDelRepositorio() {
        verify(repositorioAlumno,times(1)).guardar(anyObject());
    }

}
