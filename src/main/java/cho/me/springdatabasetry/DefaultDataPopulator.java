package cho.me.springdatabasetry;

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


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Person person = new Person();
        person.setEmail("person@person.com");
        person.setJoined("Y");
        person.setName("name");
        personRepository.save(person);
        String[] names = new String[0];
        accountRepository.findByNames(names);

    }
}
