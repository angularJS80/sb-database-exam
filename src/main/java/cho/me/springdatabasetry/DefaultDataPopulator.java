package cho.me.springdatabasetry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
    MemberRepository memberRepository;

    @Autowired
    PhoneRepository phoneRepository;

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
        Member member = new Member();
        member.setName("kim");

        memberRepository.save(member);

        Member member2 = new Member();
        member.setName("kim2");
        member.addPhone(new Phone("01022565249"));
        memberRepository.save(member2);

        List<Member> list = memberRepository.findAll();
        
        for(Member m:list ){
            System.out.println("m = " + m);
        }

    }
}
