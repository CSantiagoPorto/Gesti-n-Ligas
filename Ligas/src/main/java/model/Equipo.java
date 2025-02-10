package model;

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

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    //CascadeType.ALL -> Si elimino el equipo elimino los jugadores
    private List<Jugador> jugadores;

    @OneToOne(mappedBy = "equipo", cascade = CascadeType.ALL)
    private Entrenador entrenador;

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", liga=" + liga +
                ", jugadores=" + jugadores +
                ", entrenador=" + entrenador +
                '}';
    }
}
