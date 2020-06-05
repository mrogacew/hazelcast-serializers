package pl.com.mrogacew.hazelcast.dto;

import java.io.IOException;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.IdentifiedDataSerializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements IdentifiedDataSerializable {

    private Long personId;
    private String firstName;
    private String lastName;
//    private int age;

    @Override
    public int getFactoryId() {
        return PersonDataSerializableFactory.FACTORY_ID;
    }

    @Override
    public int getId() {
        return PersonDataSerializableFactory.PERSON_TYPE;
    }

    @Override
    public void writeData(ObjectDataOutput out) throws IOException {
        out.writeLong(personId);
        out.writeUTF(firstName);
        out.writeUTF(lastName);
//        out.writeInt(age);
    }

    @Override
    public void readData(ObjectDataInput in) throws IOException {
        this.personId = in.readLong();
        this.firstName = in.readUTF();
        this.lastName = in.readUTF();
//        this.age = in.readInt();
    }
}
