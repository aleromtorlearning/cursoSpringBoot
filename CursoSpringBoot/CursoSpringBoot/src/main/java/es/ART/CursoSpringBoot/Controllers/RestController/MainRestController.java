package es.ART.CursoSpringBoot.Controllers.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class MainRestController {
    private List <Usuario> usuarios = new ArrayList<>();

    public static class Usuario {
        private int id;
        private String nombre;
        private String email;
        private boolean esEditando;

        public Usuario(int id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
            this.esEditando = false;
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

        public boolean isEsEditando() {
            return esEditando;
        }

        public void setEsEditando(boolean esEditando) {
            this.esEditando = esEditando;
        }
    }

    public MainRestController (){
        usuarios.add(new Usuario(1, "Alejandro", "alejandro@mail"));
        usuarios.add(new Usuario(2, "Juan", "juan@mail"));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>obtenerUsuario(){
        if (usuarios!=null){
            return ResponseEntity.ok(usuarios);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        usuario.setId(usuarios.size()+1);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int id){
        Optional <Usuario> usuarioEliminado=usuarios.stream()
                .filter(usuario->usuario.getId()==id).findFirst();
        if(usuarioEliminado.isPresent()){
            usuarios.remove(usuarioEliminado.get());
            return ResponseEntity.ok(usuarioEliminado.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuarioActualizado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuario.setNombre(usuarioActualizado.getNombre());
                usuario.setEmail(usuarioActualizado.getEmail());
                return ResponseEntity.ok(usuario);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
