package pl.com.mrogacew.hazelcast.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person implements Serializable {

    private static final long serialVersionUID = 6188303060880650048L;

    private Long id;
    private String firstName;
    private String lastName;
}
