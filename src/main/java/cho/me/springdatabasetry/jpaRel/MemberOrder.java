package cho.me.springdatabasetry.jpaRel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by naver on 2018. 11. 20..
 */

@Entity
@Table(name="MEMBER_ORDER")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberOrder {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Member member;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="member_order_id")
	private List<OrderItem> orderItemsList;

	private Date orderDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	public void addOrderItem(OrderItem orderItem) {
		if(orderItemsList == null){
			orderItemsList = new ArrayList<OrderItem>();
		}
		orderItemsList.add(orderItem);
	}
}
