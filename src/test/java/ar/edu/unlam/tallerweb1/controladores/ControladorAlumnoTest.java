package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlumno;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.web.servlet.ModelAndView;
import static org.mockito.Mockito.mock;
public class ControladorAlumnoTest {
    private ServicioAlumno servicioAlumno = mock(ServicioAlumno.class);

    private ControladorAlumno controladorAlumno  = new ControladorAlumno(servicioAlumno);

    @Test
    public void crearUnAlumno(){
        Alumno alumno = givenUnAlumnoQueNoExiste();
       ModelAndView mv= whenCreoUnAlumno(alumno);
       thenAlumnoSeCreoCorrectamente(mv);


    }


    private Alumno givenUnAlumnoQueNoExiste() {
        Alumno alumno= new Alumno();
        alumno.setNombre("emiliano");
        return alumno;
    }

    private ModelAndView whenCreoUnAlumno(Alumno alumno) {
        return controladorAlumno.registrarAlumno(alumno);
    }

    private void thenAlumnoSeCreoCorrectamente(ModelAndView mv) {
        assertThat(mv.getViewName()).isEqualTo("redirect:/todos-los-alumnos");
        assertThat(mv.getModel().get("msg")).isEqualTo("bien");
    }
}
