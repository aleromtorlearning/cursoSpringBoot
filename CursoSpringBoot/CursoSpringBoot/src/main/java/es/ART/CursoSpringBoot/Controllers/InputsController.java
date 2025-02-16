package es.ART.CursoSpringBoot.Controllers;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class InputsController {

    public class Option {
        private String id;
        private String name;

        public Option(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    List<Option> options = Arrays.asList(
            new Option("1", "Option 1"),
            new Option("2", "Option 2"),
            new Option("3", "Option 3")
    );
    String texto="";
    int numero =0;
    LocalDate fecha=LocalDate.now();
    String opcion="";
    boolean check= false;
    String archivo="";
    String password="";
    String telefono="";
    String email="";
    String color = "#20232e";
    String textarea="";
    LocalDateTime fechaHora = LocalDateTime.now();
    private MultipartFile archivoData = null; // Almacena el objeto MultipartFile


    private void addModelData(Model model){
        model.addAttribute("texto", texto); // Valor inicial del input
        model.addAttribute("numero", numero);
        model.addAttribute("fecha", fecha);
        model.addAttribute("options", options);
        model.addAttribute("opcion", opcion);
        model.addAttribute("contraseña", password);
        model.addAttribute("checkbox", check);
        model.addAttribute("fechaHora", fechaHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        model.addAttribute("telefono", telefono);
        model.addAttribute("email", email);
        model.addAttribute("color", color);
        model.addAttribute("textarea", textarea);
        model.addAttribute("archivo", archivo);


    }
    @GetMapping("/inputs")
    public String mostrarFormularioTexto(Model model) {
        addModelData(model);
        return "inputs";
    }

    @PostMapping("/texto")
    public String procesarFormularioTexto(@RequestParam("texto") String texto, Model model) {
        this.texto=texto;
        addModelData(model);
        return "redirect:/inputs";
    }
    @PostMapping("/numero")
    public String procesarFormularioNumero(@RequestParam("numero") int numero, Model model) {
        this.numero=numero;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/fecha")
    public String procesarFormularioFecha(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha, Model model) {
        this.fecha=fecha;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/dropdown")
    public String handleFormSubmit(@RequestParam("option") String selectedOption, Model model) {
        this.opcion=selectedOption;
        addModelData(model);
        return "redirect:/inputs";
    }


    @PostMapping("/checkbox")
    public String procesarFormularioCheckbox(@RequestParam(value= "checkbox", defaultValue = "false") boolean checkbox , Model model) {
        this.check=checkbox;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/contraseña")
    public String procesarContraseña(@RequestParam String password, Model model) {
        this.password=password;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/telefono")
    public String procesarTelefono(@RequestParam String telefono, Model model) {
        this.telefono=telefono;
        addModelData(model);
        return "redirect:/inputs"; // Vista que muestra el mensaje de resultado
    }

    @PostMapping("/datetime")
    public String procesarFechaHora(@RequestParam("datetime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaHora, Model model) {
        this.fechaHora = fechaHora;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/email")
    public String procesarEmail(@RequestParam("email") String email, Model model) {
        this.email = email;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/color")
    public String procesarColor(@RequestParam("color") String color, Model model) {
        this.color = color;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/textarea")
    public String procesarTextarea(@RequestParam("textarea") String textarea, Model model) {
        this.textarea = textarea;
        addModelData(model);
        return "redirect:/inputs";
    }

    @PostMapping("/archivo")
    public String procesarArchivo(@RequestParam("archivo") MultipartFile archivo, Model model) throws IOException {
        if (!archivo.isEmpty()) {
            this.archivoData = archivo;
            this.archivo = archivo.getOriginalFilename(); // Guardamos el nombre del archivo
        }
        addModelData(model);
        return "redirect:/inputs";
    }


}
