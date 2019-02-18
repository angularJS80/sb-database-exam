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
        Person person = new Person();
        person.setEmail("person@person.com");
        person.setJoined("Y") ;
        person.setName("name");
        personRepository.save(person);
        personRepository.findAll();

        String[] names = new String[0];
        accountRepository.findByNames(names);

        goodsOrder();

    }

    public void goodsOrder(){

        // 상품등록
        Item item1 = Item.builder()
                .name("샤워기")
                .price(5000)
                .build();

        itemRepository.save(item1);

        Item item2 = Item.builder()
                .name("온수기")
                .price(10000)
                .build();
        itemRepository.save(item2);




        // 회원생성
        Member member = Member.builder()

                .city("seoul")
                .street("sinsuro")
                .zipCode("100")
                .name("Josh")
                .build();

        // 주문서 메인 페이지 작성
        MemberOrder memberOrder= MemberOrder.builder()
                //.member(member)
                .build();



        // 주문서에 담길 상품별 수량 , 단가 조정
        OrderItem orderItem1 = OrderItem
                .builder()
                .memberOrder(memberOrder)
                .item(item1).orderPrice(4500)
                .count(5)
                .build();

        // 주문서에 담기
        memberOrder.addOrderItem(orderItem1);


        // 주문서에 담길 상품별 수량 , 단가 조정
        OrderItem orderItem2 = OrderItem
                .builder()
                .memberOrder(memberOrder)
                .item(item2).orderPrice(9000)
                .count(1)
                .build();

        // 주문서에 담기
        memberOrder.addOrderItem(orderItem2);

        // 주문서를 회원에게 전달
        member.addMemberOrder(memberOrder);

        // 모든 사항을 회원 중심으로 저장
        memberRepository.save(member);

        // 옆집사람 동일하게
        Member member1 = Member.builder()

                .city("seoul")
                .street("sinsuro")
                .zipCode("101")
                .name("cho")
                .build();
       // member1.addMemberOrder(memberOrder);
        memberRepository.save(member1);


       // memberOrderRepository.save(memberOrder);
    }
}
