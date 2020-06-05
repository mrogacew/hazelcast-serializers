package pl.com.mrogacew.hazelcast.dto;

import java.io.IOException;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.nio.serialization.VersionedPortable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements VersionedPortable {

    public final static int ID = 1;
    public final static int CLASS_VERSION = 2;

    private Long personId;
    private String firstName;
    private String lastName;
//    private int age;

    @Override
    public int getFactoryId() {
        return PersonPortableFactory.FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeLong("personId", personId);
        writer.writeUTF("firstName", firstName);
        writer.writeUTF("lastName", lastName);
//        writer.writeInt("age", age);
    }

    @Override
    public void readPortable(PortableReader reader) throws IOException {
        this.personId = reader.readLong("personId");
        this.firstName = reader.readUTF("firstName");
        this.lastName = reader.readUTF("lastName");
//        this.age = reader.readInt("age");
    }

    @Override
    public int getClassVersion() {
        return CLASS_VERSION;
    }
}
