package pl.com.mrogacew.hazelcast.dto;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;

public class PersonPortableFactory implements PortableFactory {

    public static final int FACTORY_ID = 1;

    @Override
    public Portable create(int classId) {
        if (Person.ID == classId) {
            return new Person();
        } else {
            return null;
        }
    }
}
