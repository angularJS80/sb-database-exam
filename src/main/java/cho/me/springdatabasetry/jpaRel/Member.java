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
@Table(name="MEMBER")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {

	@Id
	@GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String city;
	@Column
	private String street;
	@Column
	private String zipCode;

	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY )
	@JoinColumn(name="member_id")
	@JsonBackReference
	private List<MemberOrder> memberOrderList;



	public void addMemberOrder(MemberOrder memberOrder) {
		if(memberOrderList ==null) {
			memberOrderList = new ArrayList<MemberOrder>();
		}
		memberOrder.setMember(this);
		memberOrderList.add(memberOrder);
	}

	@Override
	public String toString() {
		return "Member{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", zipCode='" + zipCode + '\'' +
				", memberOrderList=" + memberOrderList +
				'}';
	}

	public String getString() {
		return "Member{" +
				"id=" + id +
				", name='" + name + '\'' +
				", city='" + city + '\'' +
				", street='" + street + '\'' +
				", zipCode='" + zipCode + '\'' +
				'}';
	}


}
