package pl.com.mrogacew.hazelcast.service;

import org.springframework.stereotype.Service;
import pl.com.mrogacew.hazelcast.dto.Person;

@Service("dummy")
public class DummyPersonService implements PersonService {

    @Override
    public Person get(Long id) {
        return Person.builder()
                        .id(id)
                        .firstName("John")
                        .lastName("Doe")
                        .build();
    }

}
