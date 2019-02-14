package cho.me.springdatabasetry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> , AccountDslRepository{

}
