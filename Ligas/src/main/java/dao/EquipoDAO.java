package dao;

import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class EquipoDAO {
    private Session session;
    public List<Equipo> obternerEquiposLiga(int idLiga){
        session= HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();

        Query<Equipo> query= session.createNamedQuery("Equipo.findByLiga", Equipo.class);
        query.setParameter("idLiga", idLiga);
        List<Equipo> equipos= query.list();

        session.getTransaction().commit();
        session.close();
        return equipos;
    }
}
