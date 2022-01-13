package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Alumno;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioAlumno")
public class RepositorioAlumnoImpl implements RepositorioAlumno {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioAlumnoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void guardar(Alumno alumno) {
        sessionFactory.getCurrentSession().save(alumno);

    }

    @Override
    public List<Alumno> listarAlumnos() {
        return sessionFactory.getCurrentSession().createCriteria(Alumno.class).list();
    }

    @Override
    public void borrarAlumno(Alumno alumno) {
        sessionFactory.getCurrentSession().delete(alumno);
    }

    @Override
    public Alumno buscarAlumnoPorId(Long id) {
        return (Alumno) sessionFactory.getCurrentSession().createCriteria(Alumno.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public void editarAlumno(Alumno alumno) {
        sessionFactory.getCurrentSession().update(alumno);
    }



}