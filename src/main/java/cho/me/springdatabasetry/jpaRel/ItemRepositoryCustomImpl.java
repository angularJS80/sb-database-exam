package cho.me.springdatabasetry.jpaRel;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ItemRepositoryCustomImpl  extends QuerydslRepositorySupport implements ItemRepositoryCustom{
    public ItemRepositoryCustomImpl() {
        super(OrderItem.class);
    }

    @Override
    public List<ItemCount> findItemSummery() {
        QOrderItem qOrderItem = QOrderItem.orderItem;
// declares a maping for the gender column in the person table
        return from(qOrderItem)
                .select(Projections.constructor(ItemCount.class, qOrderItem.item.id, Wildcard.count))
                .groupBy(qOrderItem.item.id).fetch();
        //return from(qOrderItem).fetch();
    }


}
