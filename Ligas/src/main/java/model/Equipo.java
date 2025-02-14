package model;

import dao.EquipoDAO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipos")
@NamedQueries(
        {
                @NamedQuery(name = "Equipo.findByLiga", query = "FROM Equipo e WHERE e.liga.id = :idLiga")


        }
)
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_equipo")
    private String nombreEquipo;

    @Column
    private String ciudad;

    @ManyToOne
    @JoinColumn(name = "id_liga")
    private Liga liga;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //CascadeType.ALL -> Si elimino el equipo elimino los jugadores
    @ToString.Exclude
    private List<Jugador> jugadores;
    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Entrenador entrenador;

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", liga=" + liga +
                ", jugadores=" + (jugadores != null ? jugadores.stream()
                .map(Jugador::getNombre)
                .toList() : "Sin jugadores") +
                ", S entrenador=" + (entrenador != null ? entrenador.getNombre() : "Sin equipo") +
                '}';
    }



}
