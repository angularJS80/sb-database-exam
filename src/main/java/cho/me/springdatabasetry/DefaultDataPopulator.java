package cho.me.springdatabasetry;

import cho.me.springdatabasetry.jpaRel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
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
    JpaTestService jpaTestService;

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

        jpaTestService.goodsOrder();

    }


}
