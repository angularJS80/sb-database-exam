package cho.me.springdatabasetry.jpaRel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by naver on 2018. 11. 10..
 */
@Entity
@Table(name="MEMBER")
@Getter
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

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="member_id")
	private List<MemberOrder> memberOrderList;

	public void addMemberOrder(MemberOrder memberOrder) {
		if(memberOrderList ==null) {
			memberOrderList = new ArrayList<MemberOrder>();
		}
		memberOrderList.add(memberOrder);
	}
}
