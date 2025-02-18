package es.ART.CursoSpringBoot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productos")
public class ProductController {
    private List<Productos> productos = new ArrayList<>();
    public ProductController() {
        this.productos = new ArrayList<>();
    }
    public class Productos {
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;


        public Productos(String nombre, String descripcion, double precio, String categoria) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }
    }

    @GetMapping
    public String mostrarLista(Model model){
        model.addAttribute("productos", productos);
        return "productos";
    }

    @PostMapping("/crear")
    public String crearProducto (@RequestParam String nombre,
                                 @RequestParam String descripcion,
                                 @RequestParam double precio,
                                 @RequestParam String categoria){
        productos.add(new Productos(nombre, descripcion, precio, categoria));
        return "redirect:/productos";
    }

    @GetMapping("/delete/{nombre}")
    public String eliminarProductor(@PathVariable String nombre){
        productos.removeIf(p->p.getNombre().equals(nombre));
        return "redirect:/productos";
    }
}
