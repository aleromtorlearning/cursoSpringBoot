package es.ART.CursoSpringBoot.Controllers.RestController;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class MainRestController {
    private List <Usuario> usuarios = new ArrayList<>();

    public class Usuario {
        private int id;
        private String nombre;
        private String email;

        public Usuario(int id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        // Constructor, getters y setters
    }

    public MainRestController (){
        usuarios.add(new Usuario(1, "Alejandro", "alejandro@mail"));
        usuarios.add(new Usuario(2, "Juan", "juan@mail"));
    }

    @GetMapping
    public List<Usuario> obtenerUsuario(){
        return usuarios;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuario.setId(usuarios.size()+1);
        usuarios.add(usuario);
        return usuario;
    }


}
