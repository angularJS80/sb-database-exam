package cho.me.springdatabasetry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDatabaseTryApplicationTests {

	@Autowired
	AccountRepository accountRepository;

	@Test
	public void contextLoads() {
		String[] names = new String[0];
		accountRepository.findByNames(names);
	}

}

