package cho.me.springdatabasetry;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class AccountDslRepositoryImpl extends QuerydslRepositorySupport implements AccountDslRepository{


    public AccountDslRepositoryImpl() {
        super(Account.class);
    }

    @Override
    public List<Account> findByNames(String[] names) {
        QAccount account = QAccount.account;
        return from(account)
                .where(account.name.in(names))
//                .uniqueResult(account) //하나 이상이면 에러
                .fetch(); //하나 이상이면 처음거를 반환
    }
}