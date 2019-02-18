package cho.me.springdatabasetry.jpaRel;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by naver on 2018. 11. 20..
 */
@Getter
@Setter
@Entity
@Table(name="ORDER_ITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class OrderItem {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(optional=false)
	private MemberOrder memberOrder;

	@ManyToOne(optional=false)
	private Item item;

	private long orderPrice;

	private long count;
}
