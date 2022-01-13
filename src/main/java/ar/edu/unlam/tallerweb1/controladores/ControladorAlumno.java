package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorAlumno {

    private ServicioAlumno servicioAlumno;

    @Autowired
    public ControladorAlumno(ServicioAlumno servicioAlumno) {
        this.servicioAlumno = servicioAlumno;
    }


    @RequestMapping( method = RequestMethod.GET, path = "/irRegistrarAlumno")
    public ModelAndView irRegistrarAlumno(){
        ModelMap model = new ModelMap();
        Alumno alumno = new Alumno();
        model.put("alumno",alumno);
        return new ModelAndView("formulario-alumno", model);
    }



    @RequestMapping(method = RequestMethod.POST, path = "registrar-alumno")
        public ModelAndView registrarAlumno(@ModelAttribute("alumno") Alumno alumno){

            ModelMap model= new ModelMap();
            Alumno alumno1= new Alumno();
            alumno1.setNombre(alumno.getNombre());
            servicioAlumno.registrarAlumno(alumno);
            model.put("alumno",alumno);
            model.put("msg","bien");

        return new ModelAndView("redirect:/todos-los-alumnos", model);

    }

    @RequestMapping(path = "/todos-los-alumnos")
    public ModelAndView listaDeTodosLosAlumnos(){
        ModelMap model= new ModelMap();
        List<Alumno> listaDeAlumnos= servicioAlumno.listarAlumnos();
        model.put("alumnos",listaDeAlumnos);
        return new ModelAndView("alumno-lista",model);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/borrar-alumno/{id}")
    public ModelAndView borrarAlumno(@PathVariable("id") Long id){
        ModelMap model= new ModelMap();
        Alumno alumno = servicioAlumno.buscarAlumnoPorID(id);
        servicioAlumno.borrarAlumno(alumno);

        return new ModelAndView("redirect:/todos-los-alumnos", model);
    }

    @RequestMapping(path = "/modificarAlumno", method = RequestMethod.POST)
    public ModelAndView modificarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        Alumno alumnoBuscado = servicioAlumno.buscarAlumnoPorID(alumno.getId());
        ModelMap modelo = new ModelMap();
        modelo.put("alumno", alumnoBuscado);
        return new ModelAndView("editar-alumno", modelo);
    }

    @RequestMapping(path = "/editarAlumno", method = RequestMethod.POST)
    public ModelAndView editarTripulante(@ModelAttribute("alumno") Alumno alumnoRecibido) {
        Alumno alumnoBuscado = servicioAlumno.buscarAlumnoPorID(alumnoRecibido.getId());
       alumnoBuscado.setNombre(alumnoRecibido.getNombre());
        alumnoBuscado.setApellido(alumnoRecibido.getApellido());
        alumnoBuscado.setDni(alumnoRecibido.getDni());
        servicioAlumno.editarAlumno(alumnoBuscado);
        return new ModelAndView("redirect:/todos-los-alumnos");
    }


}

