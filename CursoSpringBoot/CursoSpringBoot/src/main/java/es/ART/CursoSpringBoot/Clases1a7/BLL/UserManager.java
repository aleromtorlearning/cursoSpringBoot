package es.ART.CursoSpringBoot.Clases1a7.BLL;

import es.ART.CursoSpringBoot.Clases1a7.DAL.UserDbManager;
import es.ART.CursoSpringBoot.Clases1a7.Exceptions.Exceptions.EmailInvalidoException;
import es.ART.CursoSpringBoot.Clases1a7.Exceptions.Exceptions.NullStringException;
import org.springframework.stereotype.Service;
import es.ART.CursoSpringBoot.Clases1a7.DAL.UserDbManager.Usuario;

import java.util.List;

@Service
public class UserManager {
    private final UserDbManager userDbManager;

    public UserManager(UserDbManager userDbManager){
        this.userDbManager= userDbManager;
    }

    public List<Usuario> obtenerUsuarios(){
        return userDbManager.obtenerUsuario();
    }

    public Usuario crearUsuario(Usuario usuario) {
        if(usuario.getEmail()==null || usuario.getNombre()==null){
            throw new NullStringException("");
        }

        if(usuario.getEmail().isEmpty()){
            throw new EmailInvalidoException("");
        }



        usuario.setNombre(capitalizarIniciales(usuario.getNombre()));
        return userDbManager.crearUsuario(usuario);
    }

    public Usuario editarUsuario(int id, Usuario usuario){
        usuario.setNombre(capitalizarIniciales(usuario.getNombre()));
        return userDbManager.editarUsuario(id, usuario);
    }

    public Usuario eliminarUsuario(int id){
        return userDbManager.eliminarUsuario(id);
    }

    private static String capitalizarIniciales(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }

        String[] palabras = texto.split("\\s+"); // Divide por espacios
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0))); // Primera letra en mayúscula
            }
        }
        return resultado.toString();
    }


}
