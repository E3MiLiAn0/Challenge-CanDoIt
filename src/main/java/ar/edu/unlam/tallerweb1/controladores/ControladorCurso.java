package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import ar.edu.unlam.tallerweb1.servicios.ServicioAlumno;
import ar.edu.unlam.tallerweb1.servicios.ServicioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControladorCurso {
    private ServicioCurso servicioCurso;
    private ServicioAlumno servicioAlumno;

    @Autowired
    public ControladorCurso(ServicioCurso servicioCurso, ServicioAlumno servicioAlumno) {
        this.servicioCurso = servicioCurso;
        this.servicioAlumno = servicioAlumno;

    }

    @RequestMapping( method = RequestMethod.GET, path = "/irRegistrarCurso")
    public ModelAndView irRegistrarAlumno(){
        ModelMap model = new ModelMap();
        Curso curso = new Curso();
        model.put("curso",curso);
        return new ModelAndView("formulario-curso", model);
    }

    @RequestMapping(method = RequestMethod.POST, path = "registrar-curso")
    public ModelAndView registrarAlumno(@ModelAttribute("curso") Curso curso){

        ModelMap model= new ModelMap();
        Curso curso1= new Curso();

        curso1.setNombre(curso.getNombre());
        servicioCurso.guardarCurso(curso1);
        model.put("curso",curso);
        model.put("msg","bien");

        return new ModelAndView("redirect:/todos-los-cursos", model);

    }


    @RequestMapping(path = "/todos-los-cursos")
    public ModelAndView listarCurso(){
        ModelMap model= new ModelMap();
        List<Curso> listaCursos=servicioCurso.listaDeCursos();
        model.put("cursos" ,listaCursos);
        return new ModelAndView("cursos-lista",model);
    }
   @RequestMapping(path = "/alumnosDelCurso" , method = RequestMethod.GET)
    public ModelAndView irAlistaDeAlumnosDelCurso(@RequestParam(value = "idCurso") Long idCurso){
        Curso cursoEncontrado= servicioCurso.buscarCursoPorId(idCurso);
        ModelMap model = new ModelMap();
        model.put("curso", cursoEncontrado);

        List<Alumno> alumnoList= servicioAlumno.listarAlumnos();
        model.put("listaDeAlumnos", alumnoList);
        List<Alumno> alumnosAgregados=servicioCurso.listaDeAlumnosDeUnCurso(cursoEncontrado);
        model.put("alumnosAgregados" ,alumnosAgregados);
        return new ModelAndView("alumnosEnCurso", model);
   }

   @RequestMapping(path = "/agregarAlumnosACurso", method = RequestMethod.GET)
    public ModelAndView agregarAlumnosACurso(@RequestParam(value = "idAlumno") Long idAlumno, @RequestParam(value = "idCurso") Long idCurso){
        Alumno alumno = servicioAlumno.buscarAlumnoPorID(idAlumno);
        Curso curso= servicioCurso.buscarCursoPorId(idCurso);
        ModelMap model  = new ModelMap();
        List<Alumno> alumnosEnElCurso= servicioCurso.listaDeAlumnosDeUnCurso(curso);
        for (Alumno alumno1 : alumnosEnElCurso){
            if (alumno1.getId().equals(alumno.getId())){
                model.put("error", "el alumno ya esta inscripto a este curso");
                return new ModelAndView("exepcionCurso",model);
            }
        }
           servicioCurso.agregarAlumnoAUnCurso(curso,alumno);
        return new ModelAndView("redirect:/alumnosDelCurso?idCurso=" + idCurso,model);
   }

   @RequestMapping(path = "/eliminarAlumnoDeCurso", method = RequestMethod.GET)
    public ModelAndView eliminarAlumnoDeCurso(@RequestParam(value = "idAlumno") Long idAlumno, @RequestParam (value = "idCurso") Long idCurso){
        Alumno alumno = servicioAlumno.buscarAlumnoPorID(idAlumno);
        Curso curso = servicioCurso.buscarCursoPorId(idCurso);
        servicioCurso.eliminarAlumnoDeCurso(alumno,curso);
        return new ModelAndView("redirect:/alumnosDelCurso?idCurso=" + idCurso);
   }
}
