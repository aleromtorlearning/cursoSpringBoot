package es.ART.CursoSpringBoot.RestControllers;


import es.ART.CursoSpringBoot.Objects.Empleado;
import es.ART.CursoSpringBoot.Services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmpleadoRestController {

    private final EmployeeService service;

    public EmpleadoRestController (EmployeeService service){
        this.service=service;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> obtenerTodos(){
        List<Empleado> response = service.obtenerTodos();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@RequestBody Empleado empleado){
        Empleado response= service.crear(empleado);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> eliminar(@PathVariable long id){
        Empleado response = service.eliminar(id);
        return ResponseEntity.ok(response);
    }

}
