package es.ART.CursoSpringBoot.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String puesto;
    private int anyosEnEmpresa;

    public Empleado() {}

    public Empleado(String nombre, String puesto, int anyosEnEmpresa) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.anyosEnEmpresa = anyosEnEmpresa;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public int getAnyosEnEmpresa() { return anyosEnEmpresa; }
    public void setAnyosEnEmpresa(int anyosEnEmpresa) { this.anyosEnEmpresa = anyosEnEmpresa; }


}
