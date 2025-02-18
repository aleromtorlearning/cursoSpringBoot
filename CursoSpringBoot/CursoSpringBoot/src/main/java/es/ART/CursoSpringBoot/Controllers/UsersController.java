package es.ART.CursoSpringBoot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private RestTemplate restTemplate;

}
