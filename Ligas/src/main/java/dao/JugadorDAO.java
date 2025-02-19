package dao;

import model.Equipo;
import model.Jugador;

import org.hibernate.query.Query;

import org.hibernate.Session;
import utils.HibernateUtils;
import org.hibernate.Transaction;

import java.util.List;

public class JugadorDAO {

private Session session;


    public void insertarJugador(Jugador jugador){
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction =session.beginTransaction();
        session.persist(jugador);
        transaction.commit();
        session.close();
        System.out.println("Jugador insertado correctamente.");

    }
    public List<Jugador> obtenerJugadoresPorEquipo(int idEquipo) {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query<Jugador> query = session.createQuery("FROM Jugador j WHERE j.equipo.id = :idEquipo", Jugador.class);
        query.setParameter("idEquipo", idEquipo);
        List<Jugador> jugadores = query.list();

        transaction.commit();
        session.close();
        return jugadores;
    }

    public Jugador obtenerJugador(int id){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Jugador jugador= session.get(Jugador.class, id);
        if(jugador !=null){
            System.out.println(jugador);

        }else{
            System.out.println("El jugador no existe");
        }

        transaction.commit();
        session.close();
        return jugador;
 }
 public List<Jugador> obtenerTodosJugadores(){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Query<Jugador> query =session.createNamedQuery("Jugador.findAll", Jugador.class);//Busca el trabajador con la query
        List<Jugador> listaJugadores=query.list();
        for (Jugador jugador: listaJugadores){
            System.out.println(jugador);
        }
        session.getTransaction().commit();
        session.close();
        return listaJugadores;

    }
    public void eliminarJugador(int idJugador){
        session=HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction= session.beginTransaction();

        Jugador jugador= session.get(Jugador.class, idJugador);
        if(jugador != null){
            session.remove(jugador);
            System.out.println("jugador borrado con éxtio");
        }else{
            System.out.println("No se pudo borrar el jugador");
        }


        session.getTransaction().commit();
        session.close();
    }

 public void cambiarJugadorEquipo(int idJugador, int idEquipoN){
        session= HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction= session.beginTransaction();
        Jugador jugador= session.get(Jugador.class, idJugador);
        Equipo equipo= session.get(Equipo.class, idEquipoN);
        jugador.setEquipo(equipo);
        session.merge(jugador);
     System.out.println("El jugador "+ jugador.getNombre()+" Ahora pertenece al "+ equipo.getNombreEquipo());
     transaction.commit();
     session.close();
 }
    public void actualizarJugador(Jugador jugador) {
        session = HibernateUtils.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.merge(jugador);

        transaction.commit();
        session.close();
    }



}//FIN DE LA CLASE JugadorDAO
