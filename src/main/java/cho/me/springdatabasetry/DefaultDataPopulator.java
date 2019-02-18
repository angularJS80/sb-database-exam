package cho.me.springdatabasetry;

import cho.me.springdatabasetry.jpaRel.Item;
import cho.me.springdatabasetry.jpaRel.ItemRepository;
import cho.me.springdatabasetry.jpaRel.Member;
import cho.me.springdatabasetry.jpaRel.MemberOrder;
import cho.me.springdatabasetry.jpaRel.MemberOrderRepository;
import cho.me.springdatabasetry.jpaRel.MemberRepository;
import cho.me.springdatabasetry.jpaRel.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultDataPopulator implements ApplicationRunner {

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberOrderRepository memberOrderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        /*
        Person person = new Person();
        person.setEmail("person@person.com");
        person.setJoined("Y") ;
        person.setName("name");
        personRepository.save(person);
        personRepository.findAll();

        String[] names = new String[0];
        accountRepository.findByNames(names);
        */

        goodsOrder();

    }

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
