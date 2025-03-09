package es.ART.CursoSpringBoot.Repositories;


import es.ART.CursoSpringBoot.Objects.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Empleado, Long> {
    //Optional<Empleado> findByName(String hola);
}
