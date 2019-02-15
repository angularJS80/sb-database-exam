package cho.me.springdatabasetry;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDatabaseTryApplication.class)
public class SpringDatabaseTryApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	MeetingRepository meetingRepository;

	@Test
	public void contextLoads() {
		meetingRepository.findAll();

		String[] names = new String[0];
		accountRepository.findByNames(names);

	}

}

