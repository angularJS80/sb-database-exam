package cho.me.springdatabasetry;

import java.util.List;

public interface AccountDslRepository{
    List<Account> findByNames(String[] names);
}
