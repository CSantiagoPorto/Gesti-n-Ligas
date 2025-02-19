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
    public Equipo obtenerEquipoPorId(int idEquipo){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Equipo equipo= session.get(Equipo.class, idEquipo);
        transaction.commit();
        session.close();
        return equipo;
    }

    public List<Equipo> obternerEquiposLiga(int idLiga) {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query<Equipo> query = session.createNamedQuery("Equipo.findByLiga", Equipo.class);
        query.setParameter("idLiga", idLiga);
        List<Equipo> equipos = query.list();

        session.getTransaction().commit();
        session.close();
        return equipos;
    }
    public void insertarEquipo(Equipo equipo){
        session = HibernateUtils.getSessionFactory().getCurrentSession();;
        Transaction transaction= session.beginTransaction();

        session.persist(equipo);
        transaction.commit();
        session.close();
        System.out.println("Equipo insertado: "+ equipo.getNombreEquipo());
    }
    public void eliminarEquipo(int idEquipo) {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Equipo equipo = session.get(Equipo.class, idEquipo);
        if (equipo != null) {
            session.remove(equipo);
            
            System.out.println("Equipo eliminado correctamente.");
        } else {
            System.out.println("No se encontró el equipo.");
        }

        transaction.commit();
        session.close();
    }

}
