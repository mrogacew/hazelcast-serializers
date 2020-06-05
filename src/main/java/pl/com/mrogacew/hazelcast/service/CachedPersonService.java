package pl.com.mrogacew.hazelcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.com.mrogacew.hazelcast.dto.Person;

@Primary
@Service("cached")
@CacheConfig(cacheNames = "personCache")
public class CachedPersonService implements PersonService {

    private final PersonService personService;

    @Autowired
    public CachedPersonService(@Qualifier("dummy") PersonService personService) {
        this.personService = personService;
    }

    @Override
    @Cacheable(key = "#id")
    public Person get(Long id) {
        return personService.get(id);
    }
}
