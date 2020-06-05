package pl.com.mrogacew.hazelcast.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.mrogacew.hazelcast.dto.Person;
import pl.com.mrogacew.hazelcast.service.PersonService;

@RestController
@RequestMapping("v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(@Qualifier("cached") PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") Long id) {

        return personService.get(id);
    }
}
