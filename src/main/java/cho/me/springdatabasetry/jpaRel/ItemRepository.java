package cho.me.springdatabasetry.jpaRel;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepository extends JpaRepository<Item, Long> ,ItemRepositoryCustom {

}
