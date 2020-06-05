package pl.com.mrogacew.hazelcast.service;

import pl.com.mrogacew.hazelcast.dto.Person;

public interface PersonService {
    Person get(Long id);
}
