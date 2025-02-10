package model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "entrenadores")
@NamedQueries(
        {
                @NamedQuery(name="Entrenador.findAll", query= "SELECT e FROM Entrenador e WHERE e.equipo.liga.id= :idLiga")


        }
)
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private double calificacion;

    @Column
    private int titulos;

    @OneToOne
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;

    @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", calificacion=" + calificacion +
                ", titulos=" + titulos +
                ", equipo=" + equipo +
                '}';
    }
}
