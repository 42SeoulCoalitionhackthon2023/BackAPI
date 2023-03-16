package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.entitiy.Feedback;
import hackathon.evaluation.v1.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public List<Feedback> getFeedbackFrom(Integer corrector){
        List<Feedback> feedback = feedbackRepository.findByCorrector(corrector);
        return feedback;
    }

    public List<Feedback> getFeedbackOf(Integer corrected){
        List<Feedback> feedback = feedbackRepository.findByCorrected(corrected);
        return feedback;
    }


}
