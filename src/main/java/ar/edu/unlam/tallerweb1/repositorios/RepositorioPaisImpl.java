package ar.edu.unlam.tallerweb1.repositorios;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPais")
public class RepositorioPaisImpl implements RepositorioPais {

    private SessionFactory sessionFactory;
    @Autowired
    public RepositorioPaisImpl( SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }
    @Override
    public List <Pais> buscarPaisesPorCantidad(Integer cantidadDeHabitantes) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class).add(Restrictions.gt("habitantes",cantidadDeHabitantes)).list();
    }
    @Override
    public List<Pais> buscarPaisesPorIdioma(String idioma) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class).add(Restrictions.like("idioma","%"+idioma+"%")).list();
    }
    public List<Pais> buscarPaisesPorIdioma(String idioma1 ,String idioma2 ) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class)
                .add(Restrictions.or(Restrictions.like("idioma","%"+idioma1+"%"),
                        Restrictions.like("idioma","%"+idioma2+"%"))).list();
    }
    @Override
    public List<Pais> buscarPaisPorContinente(String continente) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class).add(Restrictions.like("continente","%"+continente+"%")).list();
    }
    public List<Pais> buscarPaisPorContinente(String continente,String continente2) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class)
                .add(Restrictions.or(Restrictions.like("continente","%"+continente+"%"),
                        Restrictions.like("continente","%"+continente2+"%"))).list();
    }
    @Override
    public List<Pais> buscarPaisPorContinentePorIdiomaCantidadMaximaDeHabitantes(String continente,String idioma, Integer cantidadDeHabitantes) {
        final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Pais.class)
                .add(Restrictions.lt("habitantes",cantidadDeHabitantes))
                .add(Restrictions.like("continente","%"+continente+"%"))
                .add(Restrictions.like("idioma","%"+idioma+"%"))
                .list();
    }

}
