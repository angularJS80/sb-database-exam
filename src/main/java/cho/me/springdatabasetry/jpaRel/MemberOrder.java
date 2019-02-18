package cho.me.springdatabasetry.jpaRel;

import lombok.*;

import javax.persistence.*;
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
@Setter
@Getter
public class MemberOrder {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Member member;

	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY )
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

	@Override
	public String toString() {
		return "MemberOrder{" +
				"id=" + id +
				//", member=" + member +
				", orderItemsList=" + orderItemsList +
				", orderDate=" + orderDate +
				", status=" + status +
				'}';
	}
}
