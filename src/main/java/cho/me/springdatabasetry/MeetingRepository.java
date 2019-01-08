package cho.me.springdatabasetry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Person, Long> {
}
