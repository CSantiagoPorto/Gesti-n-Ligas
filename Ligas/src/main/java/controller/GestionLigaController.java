package controller;

import dao.EntrenadorDAO;
import dao.EquipoDAO;
import dao.JugadorDAO;
import dao.LigaDAO;
import model.Entrenador;
import model.Equipo;
import model.Jugador;
import model.Liga;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.util.List;

public class GestionLigaController {

    private LigaDAO ligaDAO = new LigaDAO();
    private EquipoDAO equipoDAO = new EquipoDAO();
    private JugadorDAO jugadorDAO = new JugadorDAO();
    private EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

    public void insertarLiga(Liga liga) {
        ligaDAO.insertarLiga(liga);
    }

    public void mostrarLiga(int ligaId) {
        Liga liga = ligaDAO.encontrarLiga(ligaId);
        if (liga != null) {
            System.out.println("Liga: " + liga.getNombreLiga());
            System.out.println("Fecha de inicio: " + liga.getFechaInicio());
            System.out.println("Fecha de fin: " + liga.getFechaFin());
        } else {
            System.out.println("No se encontró la liga.");
        }
    }
    public void todasLigas(){
        List<Liga>ligas =ligaDAO.ligasTodas();
        System.out.println("Listado de ligas:");
        for(Liga liga:ligas){
            System.out.println(liga.getNombreLiga());
        }

    }
    public void eliminarLiga(int ligaId) {
        ligaDAO.eliminarLiga(ligaId);
    }

    public void mostrarEquiposLiga(int idLiga) {
        List<Equipo> equipos = equipoDAO.obternerEquiposLiga(idLiga);
        if (equipos.isEmpty()) {
            System.out.println("No hay equipos en la liga con ID " + idLiga);
        } else {
            System.out.println("Equipos en la liga " + idLiga + ":");
            for (Equipo equipo : equipos) {
                System.out.println("- " + equipo.getNombreEquipo());
            }
        }
    }


    public void mostrarJugadoresEquipo(int idEquipo) {
        List<Jugador> jugadores = jugadorDAO.obtenerJugadoresPorEquipo(idEquipo);
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores en el equipo con ID " + idEquipo);
        } else {
            System.out.println("Jugadores en el equipo " + idEquipo + ":");
            for (Jugador jugador : jugadores) {
                System.out.println("- " + jugador.getNombre() + " | Posición: " + jugador.getPosicion() + " | Goles: " + jugador.getGoles());
            }
        }
    }
    public void insertarEquipo(Equipo equipo){
        equipoDAO.insertarEquipo(equipo);
    }

    public void transferirJugador(int idJugador, int idEquipoN) {
        jugadorDAO. cambiarJugadorEquipo(idJugador, idEquipoN);
    }

    public void insertarEntrenador(int idEquipo,Entrenador entrenador) {
        entrenadorDAO.insertarEntrenador(idEquipo, entrenador);
    }
    public void entrenadorXEquipo(int idEquipo, int idEntrenador){
        Entrenador entrenador=entrenadorDAO.obtenerEntrenadorXEquipo(idEquipo,  idEntrenador);
        if(entrenador!=null){
            System.out.println(entrenador);
        }else{
            System.out.println("No se encontró entrenador asignado");
        }

    }

    public void insertarJugador(Jugador jugador){
        jugadorDAO.insertarJugador(jugador);
    }
    public void mostrarEntrenadoresPorLiga(int idLiga) {
        List<Entrenador> entrenadores = entrenadorDAO.entrenadoresXLiga(idLiga);
        if (!entrenadores.isEmpty()) {
            System.out.println("Entrenadores en la liga " + idLiga + ":");
            for (Entrenador entrenador : entrenadores) {
                System.out.println(entrenador);
            }
        } else {
            System.out.println("No hay entrenadores en esta liga.");
        }
    }



}
