package es.ART.CursoSpringBoot;

import jakarta.persistence.*;

@Entity
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String puesto;

    public int getAnyosEnEmpresa() {
        return anyosEnEmpresa;
    }

    public void setAnyosEnEmpresa(int anyosEnEmpresa) {
        this.anyosEnEmpresa = anyosEnEmpresa;
    }

    private int anyosEnEmpresa;

    public Empleado() {
    }

    public Empleado(Long id, String nombre, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
