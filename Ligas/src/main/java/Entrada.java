

import controller.GestionLigaController;
import model.Entrenador;
import model.Equipo;
import model.Jugador;
import model.Liga;

public class Entrada {
    public static void main(String[] args) {
        GestionLigaController gestionLiga = new GestionLigaController();


        Liga laLiga = new Liga();
        laLiga.setNombreLiga("LaLiga Española");
        laLiga.setFechaInicio("2024-08-15");
        laLiga.setFechaFin("2025-05-25");
        gestionLiga.insertarLiga(laLiga);


        Equipo realMadrid = new Equipo();
        realMadrid.setNombreEquipo("Real Madrid");
        realMadrid.setCiudad("Madrid");
        realMadrid.setLiga(laLiga);

        Equipo barcelona = new Equipo();
        barcelona.setNombreEquipo("FC Barcelona");
        barcelona.setCiudad("Barcelona");
        barcelona.setLiga(laLiga);

        Equipo atleticoMadrid = new Equipo();
        atleticoMadrid.setNombreEquipo("Atlético de Madrid");
        atleticoMadrid.setCiudad("Madrid");
        atleticoMadrid.setLiga(laLiga);

        gestionLiga.insertarEquipo(realMadrid);
        gestionLiga.insertarEquipo(barcelona);
        gestionLiga.insertarEquipo(atleticoMadrid);

        // Crear seis jugadores reales y asignarlos a los equipos
        Jugador viniJr = new Jugador(0, "Vinícius Júnior", "Delantero", 150000000, 12, "Brasil", realMadrid);
        Jugador bellingham = new Jugador(0, "Jude Bellingham", "Mediocampista", 120000000, 10, "Inglaterra", realMadrid);
        Jugador lewandowski = new Jugador(0, "Robert Lewandowski", "Delantero", 30000000, 18, "Polonia", barcelona);
        Jugador pedri = new Jugador(0, "Pedri", "Mediocampista", 90000000, 6, "España", barcelona);
        Jugador griezmann = new Jugador(0, "Antoine Griezmann", "Delantero", 35000000, 15, "Francia", atleticoMadrid);
        Jugador koke = new Jugador(0, "Koke", "Mediocampista", 20000000, 2, "España", atleticoMadrid);

        gestionLiga.insertarJugador(viniJr);
        gestionLiga.insertarJugador(bellingham);
        gestionLiga.insertarJugador(lewandowski);
        gestionLiga.insertarJugador(pedri);
        gestionLiga.insertarJugador(griezmann);
        gestionLiga.insertarJugador(koke);

        // Fichar 2 jugadores de otro equipo
        System.out.println(" Transferencia: Lewandowski pasa del Barcelona al Real Madrid.");
        gestionLiga.transferirJugador(lewandowski.getId(), realMadrid.getId());

        System.out.println(" Transferencia: Koke pasa del Atlético de Madrid al Barcelona.");
        gestionLiga.transferirJugador(koke.getId(), barcelona.getId());

        // Crear tres entrenadores  y asignarlos a equipos
        Entrenador ancelotti = new Entrenador(0, "Carlo Ancelotti", 9.5, 4, realMadrid);
        Entrenador xavi = new Entrenador(0, "Xavi Hernández", 8.0, 1, barcelona);
        Entrenador simeone = new Entrenador(0, "Diego Simeone", 9.0, 2, atleticoMadrid);

        gestionLiga.insertarEntrenador(realMadrid.getId(), ancelotti);
        gestionLiga.insertarEntrenador(barcelona.getId(), xavi);
        gestionLiga.insertarEntrenador(atleticoMadrid.getId(), simeone);

        // Mostrar equipos
        System.out.println(" Equipos en LaLiga Española:");
        gestionLiga.mostrarEquiposLiga(laLiga.getId());

        //  Mostrar jugadores de un equipo (Real Madrid)
        System.out.println(" Jugadores del Real Madrid:");
        gestionLiga.mostrarJugadoresEquipo(realMadrid.getId());

        //  Mostrar entrenadores de la liga
        System.out.println("Entrenadores de los equipos de LaLiga:");
        gestionLiga.mostrarEntrenadoresPorLiga(laLiga.getId());
    }
}
