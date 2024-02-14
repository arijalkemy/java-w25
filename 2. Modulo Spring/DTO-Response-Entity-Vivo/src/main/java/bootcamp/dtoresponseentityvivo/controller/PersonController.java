package bootcamp.dtoresponseentityvivo.controller;

import bootcamp.dtoresponseentityvivo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private IPersonService personService;

}
