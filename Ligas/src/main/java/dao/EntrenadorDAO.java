package dao;

import model.Entrenador;
import model.Equipo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class EntrenadorDAO {
    private Session session;
    //Primero el CRUD
     public void insertarEntrenador(int idEquipo, Entrenador entrenador){
         session= HibernateUtils.getSessionFactory().getCurrentSession();
         Transaction transaction= session.beginTransaction();
         Equipo equipo= session.get(Equipo.class, idEquipo);
         if(equipo!= null){
             entrenador.setEquipo(equipo);
             session.persist(entrenador);
             System.out.println("El entrenador "+ entrenador.getNombre()+ "Pertenece al equipo: "+ equipo.getNombreEquipo());
         }else{
             System.out.println("No se pudo asignar el entrenador al equipo");
         }
         transaction.commit();
         session.close();
     }
    public Entrenador obtenerEntrenadorXEquipo(int idEquipo, int idEntrenador){
         session=HibernateUtils.getSessionFactory().getCurrentSession();
         Transaction transaction=session.beginTransaction();
         Equipo equipo= session.get(Equipo.class, idEquipo);
         Entrenador entrenador= session.get(Entrenador.class, idEntrenador);
         if(equipo!=null ){
             entrenador=equipo.getEntrenador();
             System.out.println("El entrenador es: "+ entrenador.getNombre());

         }
        transaction.commit();
         session.close();

         return entrenador;
    }

    public List<Entrenador>entrenadoresXLiga(int idLiga){
         session=HibernateUtils.getSessionFactory().getCurrentSession();
         Transaction transaction=session.beginTransaction();
         Query<Entrenador> query = session.createNamedQuery("Entrenador.findAll", Entrenador.class);
         query.setParameter("idLiga", idLiga);//Necesito esto para pasarle la liga que es
        List<Entrenador>listaEntrenadores= query.list();


         transaction.commit();
         session.close();


         return listaEntrenadores;
    }

}
