package es.ART.CursoSpringBoot.Clases1a7.Controllers;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private List<Usuario> users = new ArrayList<Usuario>();

    public class Usuario {
        private String name;
        private String password;
        private String email;


        public Usuario() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    @GetMapping("/")
    public String indez(){
        return "index";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost34(@ModelAttribute Usuario user, Model model){
        model.addAttribute("Usuario" ,user);
        users.add(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String signupPost234(@RequestParam String email, @RequestParam String password, Model model){
        for (Usuario usuario : users) {
            if (usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) {
                return "redirect:/";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/delete/{name}")
    public String delete(@PathVariable String name){
        users.removeIf(p->p.getName().equals(name));
        return "redirect:/";
    }



}
