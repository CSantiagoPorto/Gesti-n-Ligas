package model;

import jakarta.persistence.*;
import lombok.*;
import model.Equipo;

import java.io.Serializable;
@Entity
@Table(name="jugadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@NamedQueries(
        {
                @NamedQuery(name= "Jugador.findAll", query= "FROM Jugador")
        }
)

public class Jugador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String posicion;
    @Column( name ="valor_mercado")
    private int valorMercado;
    @Column
    private int goles;
    @Column
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name="id_equipo")//Esto marca la FK
    @ToString.Exclude //Esto evita la recursividad infinita

    private Equipo equipo;// Esto nos permite acceder a un objeto equipo

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", posicion='" + posicion + '\'' +
                ", valorMercado=" + valorMercado +
                ", goles=" + goles +
                ", nacionalidad='" + nacionalidad + '\'' +
               ", equipo=" + (equipo != null ? equipo.getNombreEquipo() : "Sin equipo") +
                '}';
    }
}
