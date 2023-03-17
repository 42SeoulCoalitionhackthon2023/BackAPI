package hackathon.evaluation.v1.repository;

import hackathon.evaluation.v1.domain.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByIntraId(String intraId);
}
