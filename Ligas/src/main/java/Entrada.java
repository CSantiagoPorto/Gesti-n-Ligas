package main;

import controller.GestionLigaController;
import model.Entrenador;
import model.Equipo;
import model.Jugador;
import model.Liga;

import java.util.List;

public class Entrada {
    public static void main(String[] args) {
        GestionLigaController gestionLiga = new GestionLigaController();

        // 1. Insertar una nueva liga
        Liga nuevaLiga = new Liga();
        nuevaLiga.setNombreLiga("Liga Prueba");
        nuevaLiga.setFechaInicio("2025-08-01");
        nuevaLiga.setFechaFin("2026-05-31");
        gestionLiga.insertarLiga(nuevaLiga);

        // 2. Mostrar todas las ligas existentes
        gestionLiga.todasLigas();

        // 3. Mostrar los equipos de una liga específica (ejemplo: id = 7)
        int idLigaEjemplo = 1;
        System.out.println("Equipos en la liga con ID " + idLigaEjemplo + ":");
        gestionLiga.mostrarEquiposLiga(idLigaEjemplo);

        // 4. Transferir un jugador a otro equipo (ejemplo: jugador ID = 7, equipo destino ID = 8)
        int jugadorId = 7;
        int nuevoEquipoId = 8;
        gestionLiga.transferirJugador(jugadorId, nuevoEquipoId);

        // 5. Mostrar todos los jugadores de un equipo específico (ejemplo: equipo ID = 7)
        int equipoIdEjemplo = 7;
        System.out.println("Jugadores en el equipo con ID " + equipoIdEjemplo + ":");
        gestionLiga.mostrarJugadoresEquipo(equipoIdEjemplo);
    }
}
