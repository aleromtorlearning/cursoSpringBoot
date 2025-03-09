package es.ART.CursoSpringBoot.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Empleado extends Usuario{

    private String puesto;
    private int anyosEnEmpresa;

    @OneToOne(mappedBy = "empleado", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JsonManagedReference
    private TarjetaIdentificacion tarjetaIdentificacion;

    public Empleado() {}

    public Empleado(String nombre, String puesto, int anyosEnEmpresa) {
        super(nombre);
        this.puesto = puesto;
        this.anyosEnEmpresa = anyosEnEmpresa;
    }

    // Getters y Setters


    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public int getAnyosEnEmpresa() { return anyosEnEmpresa; }
    public void setAnyosEnEmpresa(int anyosEnEmpresa) { this.anyosEnEmpresa = anyosEnEmpresa; }


    public TarjetaIdentificacion getTarjetaIdentificacion() {
        return tarjetaIdentificacion;
    }

    public void setTarjetaIdentificacion(TarjetaIdentificacion tarjetaIdentificacion) {
        this.tarjetaIdentificacion = tarjetaIdentificacion;
    }
}
