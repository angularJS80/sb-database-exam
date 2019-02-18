package cho.me.springdatabasetry.jpaRel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class JpaTestService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberOrderRepository memberOrderRepository;

    @Transactional
    public void goodsOrder(){
        // 상품생성
        List<Item> items = addDefaultItem();
        itemRepository.saveAll(items);
        // 회원 생성
        List<Member> members = addDefaultMember();

        // 회원들에 주문서 작성 ( 동일한 상품목록)
        orrding(members,items);

        // 모든 사항을 회원 중심으로 저장
        memberRepository.saveAll(members);

        members = memberRepository.findAll();
        for(Member member:members ){
            System.out.println("member = " + member);
        }


        List<MemberOrder> memberOrders  = memberOrderRepository.findAll();

        for(MemberOrder memberOrder:memberOrders ){
            System.out.println("memberOrder = " + memberOrder);
        }





    }

    private void orrding(List<Member> members, List<Item> items) {
        // 주문서 작성
        //  모든회원에게 같은 주문서 할당
        for(Member member:members){
            MemberOrder memberOrder = createMemberOrder(items);
            member.addMemberOrder(memberOrder);
        }
    }

    private MemberOrder  createMemberOrder( List<Item> items) {
        MemberOrder memberOrder= MemberOrder.builder().build();
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();

        // 주문서에 담길 첫번째 상품 수량 , 단가 조정 1+1 이벤트
        orderItemList.add(
                OrderItem.builder().memberOrder(memberOrder).item(items.get(0)).orderPrice(2500).count(2).build()
        );

        orderItemList.add(
                OrderItem.builder().memberOrder(memberOrder).item(items.get(0)).orderPrice(5000).count(2).build()
        );

        // 주문서에 담기
        memberOrder.setOrderItemsList(orderItemList);
        return memberOrder;
    }


    private List<Member> addDefaultMember() {
        List<Member> members = new ArrayList<Member>();
        // josh 회원 인스턴스 생성
        members.add(
                Member.builder().city("seoul").street("sinsuro").zipCode("100").name("Josh").build()
        );
        // cho 회원 인스턴스 생성
        members.add(
                Member.builder().city("seoul").street("sinsuro").zipCode("101").name("cho").build()
        );
        return members;
    }

    private List<Item> addDefaultItem() {
        List<Item> items = new ArrayList<Item>();
        // 샤워기 상품인스턴스 생성
        items.add(
                Item.builder().name("샤워기").price(5000).build()
        );

        // 원수기 상품인스턴스 생성
        items.add(
                Item.builder().name("온수기").price(10000).build()
        );
        return items;
    }
}
