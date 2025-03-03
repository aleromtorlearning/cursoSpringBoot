package es.ART.CursoSpringBoot.Clases1a7.Controllers.RestController;

import es.ART.CursoSpringBoot.Clases1a7.BLL.UserManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.ART.CursoSpringBoot.Clases1a7.DAL.UserDbManager.Usuario;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class MainRestController {


    private final UserManager userManager;
    public MainRestController(UserManager userManager){
        this.userManager=userManager;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>>obtenerUsuario(){
        List<Usuario> usuarios=userManager.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(userManager.crearUsuario(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable int id, @RequestBody Usuario user){
        Usuario usuario=userManager.editarUsuario(id, user);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> eliminarUsuario(@PathVariable int id){
        Usuario usuario=userManager.eliminarUsuario(id);
        return ResponseEntity.ok(usuario);
    }

}
