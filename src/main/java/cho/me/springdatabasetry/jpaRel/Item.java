package cho.me.springdatabasetry.jpaRel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by naver on 2018. 11. 20..
 */
@Getter
@Entity
@Table(name="ITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {
	@Id
	@GeneratedValue
	private int id;

	private String name;
	private long price;
	private long stockQuantity;

	@OneToMany
	@JoinColumn(name="item_id")
	private List<OrderItem> orderItemList;

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", name='" + name + '\'' +
				", price=" + price +
				", stockQuantity=" + stockQuantity +
				", orderItemList=" + orderItemList +
				'}';
	}
}
