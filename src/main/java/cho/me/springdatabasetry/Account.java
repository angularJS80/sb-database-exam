package cho.me.springdatabasetry;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

public class Account {
    @Id
    private Long id;
    private String name;
    private String email;

}
