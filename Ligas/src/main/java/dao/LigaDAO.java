package dao;

import model.Equipo;
import model.Liga;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class LigaDAO {
    private Session session;
    public void asignarEquipoLiga(


    ){}
    public void insertarLiga(Liga liga){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction =session.beginTransaction();
        session.persist(liga);
        transaction.commit();
        session.close();
        System.out.println("Liga insertado correctamente.");

    }
    public Liga encontrarLiga(int id){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Liga liga= session.get(Liga.class, id);
        session.getTransaction().commit();
        session.close();
        if(liga !=null){
            System.out.println("liga encontrada");
            return liga;
        }return null;

    }

    public List<Liga> ligasTodas(){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query<Liga> query=session.createQuery("FROM Liga", Liga.class);
        List<Liga>listaLigas=query.list();

        session.getTransaction().commit();
        session.close();


        return listaLigas;
    }


    public void actualizarLiga(Liga liga) {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction= session.beginTransaction();

        session.merge(liga);
        transaction.commit();
        session.close();
        System.out.println("Liga actualizada correctamente.");

    }

    public void eliminarLiga(int id){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Liga liga=session.get(Liga.class,id);
        if(liga != null){
            session.delete(liga);
            System.out.println("Liga eliminada correctamente");
        }else{
            System.out.println("La Liga no se pudo eliminar");
        }
        transaction.commit();
        session.close();
    }
    public void asignarEquipoLiga(int idEquipo, int idLiga){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Equipo equipo=session.get(Equipo.class,idEquipo);
        Liga liga=session.get(Liga.class,idLiga);
        if(equipo !=null&&liga!=null){
            equipo.setLiga(liga);
            session.merge(equipo);
            System.out.println("Equipo asignado correctamente");
        }else {
            System.out.println("No se pudo asignar el equipo");
        }
        transaction.commit();
        session.close();
    }



    //FALTA:
    //Asignar equipo a Liga
    //Para eso necesito saber qué equipos son de cada liga
    //Actualizar desde el Controller

}
