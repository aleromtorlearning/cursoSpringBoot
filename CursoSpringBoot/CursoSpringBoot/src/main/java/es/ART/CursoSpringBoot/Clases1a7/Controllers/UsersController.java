package es.ART.CursoSpringBoot.Clases1a7.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import es.ART.CursoSpringBoot.Clases1a7.DAL.UserDbManager.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsersController {
    private String usersUrl = "http://localhost:8080/api/users";
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping
    public String obtenerUsuarios(Model model){
        List<Usuario> usuarios=new ArrayList<>();
        try{
            ResponseEntity<List<Usuario>> response=restTemplate.exchange(
                    usersUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Usuario>>() {
                    }
            );
            if (response.getBody()!=null){
                usuarios=response.getBody();
            }
        }
        catch(Exception e){
            System.err.println("Error al traer la lista de usuarios. La envío vacía para que el front funcione");
            e.printStackTrace();
        }
            model.addAttribute("usuarios", usuarios);
            return "usuarios";
    }

    @PostMapping
    public String crearUsuario(@RequestParam String nombre, @RequestParam String email){
        try{
            Usuario usuario = new Usuario(0, nombre, email);
            HttpHeaders headers= new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario,  headers);
            restTemplate.postForEntity(usersUrl, request, Usuario.class);
        }
        catch (Exception e){
            System.err.println("Error al crear el usuario, muestra la vista igualmente");
            e.printStackTrace();
        }
        return "redirect:/usuarios";
    }

//    @GetMapping("/eliminar/{id}")
//    public String eliminar(@PathVariable int id)
//    {
//        try{
//            restTemplate.delete(usersUrl +"/" + id);
//        }
//        catch (Exception e){
//            System.err.println("Error al eliminar el usuario, muestra la vista igualmente");
//            e.printStackTrace();
//        }
//        return "redirect:/usuarios";
//    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        try {
            restTemplate.delete(usersUrl + "/" + id);
        } catch (Exception e) {
            System.err.println("Error al eliminar el usuario, muestra la vista igualmente");
            e.printStackTrace();
        }
        return "redirect:/usuarios";
    }



    @GetMapping("/{id}")
    public String obtenerParaEditar(@PathVariable int id,  Model model){
        List<Usuario> usuarios=new ArrayList<>();
        try{
            ResponseEntity<List<Usuario>> response=restTemplate.exchange(
                    usersUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Usuario>>() {
                    }
            );
            if (response.getBody()!=null){
                usuarios=response.getBody();
                for (Usuario usuario : usuarios) {
                    if (usuario.getId() == id) {
                        usuario.setEsEditando(true);
                    }
                }
            }
        }
        catch(Exception e){
            System.err.println("Error al traer la lista de usuarios. La envío vacía para que el front funcione");
            e.printStackTrace();
        }
        model.addAttribute("usuarios", usuarios);
        return "usuarios";
    }

    @PutMapping("/{id}")
    public String actualizarUsuario(@PathVariable int id, @RequestParam String nombre, @RequestParam String email) {
        Usuario usuarioActualizado = new Usuario(id, nombre, email);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Usuario> request = new HttpEntity<>(usuarioActualizado, headers);
        restTemplate.exchange(usersUrl + "/" + id, HttpMethod.PUT, request, Void.class);
        return "redirect:/usuarios";
    }




}





















