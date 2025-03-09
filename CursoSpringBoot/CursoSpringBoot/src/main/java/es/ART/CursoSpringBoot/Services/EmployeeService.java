package es.ART.CursoSpringBoot.Services;

import es.ART.CursoSpringBoot.Objects.Empleado;
import es.ART.CursoSpringBoot.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService (EmployeeRepository repository){
        this.repository=repository;
    }

    public List<Empleado> obtenerTodos() {
        return repository.findAll();
    }

    public Empleado crear(Empleado empleado) {
        empleado.setId(null);
        return repository.save(empleado);
    }

    public Empleado editar(long id, Empleado entrada) {
        Optional<Empleado> opcional =repository.findById(id);
        if(opcional.isPresent()){
            Empleado aModificar=opcional.get();
            aModificar.setNombre(entrada.getNombre());
            aModificar.setPuesto(entrada.getPuesto());
            aModificar.setAnyosEnEmpresa(entrada.getAnyosEnEmpresa());
            repository.save(aModificar);
            return aModificar;
        }
        return null;
    }

    public Empleado eliminar(long id) {
        Optional<Empleado> opcional =repository.findById(id);
        if(opcional.isPresent()){
            Empleado aEliminar=opcional.get();
            repository.delete(aEliminar);
            return aEliminar;
        }
        return null;
    }

/**
 *
 * save->guardar un dato  (nuevo o no)   (INSERT INTO ///  UPDATE )
 * findAll->recoge todos los datos de la tabla (SELECT * FROM TABLA)
 * delete->elimina datos de la tabla (DELETE FROM TABLA WHERE OBJETO )
 * findByCAMPO -> recoge datos por campo (SELECT FROM TABLA WHERE CAMPO)
 *
 * BY->SELECCIONAR EL CAMPO
 * AND/OR ->SELECCIONES
 * GREATER THAN/BETWEEN FindByIdGreaterThan(2)
 * ORDER BY -> ordenar según un campo   (SELECT * FROM TABLA ORDER BY CAMPO DESC)
 *
 *
 * FindByIdGreaterThanOrderByName(2)
 *
 *
 *
 *
 * @QUERY ("SELECT * FROM Empleado e WHERE e.nombre =:@nombre")
 * List<Empleado> buscarPorNombre (@Param ("@nombre") String nombre);
 *
 *
 * empleados=buscarPorNombre("Juan");
 *
 *
 */


}
