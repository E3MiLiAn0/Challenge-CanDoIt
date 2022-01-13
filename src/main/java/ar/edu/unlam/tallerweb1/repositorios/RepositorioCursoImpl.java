package ar.edu.unlam.tallerweb1.repositorios;


import ar.edu.unlam.tallerweb1.modelo.Alumno;
import ar.edu.unlam.tallerweb1.modelo.Curso;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioCurso")
public class RepositorioCursoImpl implements RepositorioCurso{
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioCursoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void agregarAlumnoAunCurso(Curso curso) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(curso);
    }

    @Override
    public void guardarCurso(Curso curso) {
        sessionFactory.getCurrentSession().save(curso);

    }

    @Override
    public void borrarCurso(Curso curso) {
        sessionFactory.getCurrentSession().delete(curso);

    }

    @Override
    public void editarCurso(Curso curso) {
        sessionFactory.getCurrentSession().update(curso);

    }

    @Override
    public List<Curso> listarCurso() {
        List<Curso> listaDeCursos = sessionFactory.getCurrentSession().createCriteria(Curso.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)

                .list();
        return listaDeCursos;
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        return (Curso) sessionFactory.getCurrentSession().createCriteria(Curso.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<Alumno> listarAlumnosDeUnCurso(Curso curso) {
        List<Alumno> listaDealumnos =  sessionFactory.getCurrentSession()
                .createCriteria(Alumno.class)
                .createAlias("cursos", "cursosjoin")
                .add(Restrictions.eq("cursosjoin.id", curso.getId()))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .list();

        return listaDealumnos;
    }

    @Override
    public void eliminarAlumnoDeCurso(Curso curso) {
        sessionFactory.getCurrentSession().clear();
        sessionFactory.getCurrentSession().saveOrUpdate(curso);
    }
}
