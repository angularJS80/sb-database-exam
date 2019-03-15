package cho.me.springdatabasetry.jpaRel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by naver on 2018. 11. 10..
 */
@Entity
@Table(name="MEMBER_TYPE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberType {
	@Id
	long memberTypeId;

	@ManyToOne(optional=false)
	@JsonManagedReference
	private MemberTypeGroup memberTypeGroup;

}
