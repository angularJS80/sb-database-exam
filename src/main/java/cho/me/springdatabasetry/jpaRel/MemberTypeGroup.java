package cho.me.springdatabasetry.jpaRel;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MEMBER_TYPE_GROUP")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberTypeGroup {
    @Id
    long memberTypeGroupId;

    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY )
    private List<MemberType> memberTypes;
}
