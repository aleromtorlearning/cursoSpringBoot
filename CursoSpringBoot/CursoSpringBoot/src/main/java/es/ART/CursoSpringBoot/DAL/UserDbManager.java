package es.ART.CursoSpringBoot.DAL;

import es.ART.CursoSpringBoot.Controllers.RestController.MainRestController;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDbManager {
    private List<Usuario> usuarios = new ArrayList<>();

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

    public UserDbManager (){
        usuarios.add(new Usuario(1, "Alejandro", "alejandro@mail"));
        usuarios.add(new Usuario(2, "Juan", "juan@mail"));
        usuarios.add(new Usuario(3, "Mauro", "maruro@mail"));
        usuarios.add(new Usuario(4, "Luis", "luis@mail"));
    }

    public List<Usuario> obtenerUsuario() {
        return usuarios;
    }

    public Usuario crearUsuario(Usuario usuario){
        usuario.setId(usuarios.size()+1);
        usuarios.add(usuario);
        return usuario;
    }

    public Usuario editarUsuario(int id, Usuario usuarioActualizar){
        for (Usuario user : usuarios){
            if (user.getId()==id){
                user.setNombre(usuarioActualizar.getNombre());
                user.setEmail(usuarioActualizar.getEmail());
                return user;
            }
        }
        return null;
    }

    public Usuario eliminarUsuario(int id){
        for (Usuario user : usuarios){
            if (user.getId()==id){
                usuarios.remove(user);
                return user;
            }
        }
        return null;
    }

}
