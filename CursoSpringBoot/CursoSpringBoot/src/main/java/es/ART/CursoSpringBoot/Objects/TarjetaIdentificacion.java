package es.ART.CursoSpringBoot.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class TarjetaIdentificacion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String numeroTarjeta;

    @OneToOne
    @JoinColumn(name="empleado_id")
    @JsonBackReference
    private Empleado empleado;


    public TarjetaIdentificacion() {
    }

    public TarjetaIdentificacion(long id, String numeroTarjeta, Empleado empleado) {
        this.id = id;
        this.numeroTarjeta = numeroTarjeta;
        this.empleado = empleado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
