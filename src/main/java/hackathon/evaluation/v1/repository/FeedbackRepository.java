package hackathon.evaluation.v1.repository;

import hackathon.evaluation.v1.domain.entitiy.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByCorrectorOrderByCreatedAtDesc(Integer corrector);
    List<Feedback> findByCorrected(Integer corrected);
}
