package cho.me.springdatabasetry.jpaRel;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.persistence.*;

/**
 * Created by naver on 2018. 11. 20..
 */
@Getter
@Setter
public class OrderItemCount {
	@QueryProjection
	public OrderItemCount(int itemId, int orderCount) {
		this.itemId = itemId;
		this.orderCount = orderCount;
	}

	private int itemId;
	private int orderCount;
}
