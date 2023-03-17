package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.dto.FeedbackDto;
import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.Feedback;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    public List<FeedbackDto> getCommentBy(Integer corrector){
        List<Feedback> feedback = feedbackRepository.findByCorrector(corrector);
        return getFeedbackDtoList(feedback);
    }

    public List<FeedbackDto> getCommentOf(Integer corrected){
        List<Feedback> feedback = feedbackRepository.findByCorrected(corrected);
        return getFeedbackDtoList(feedback);
    }

    private static List<FeedbackDto> getFeedbackDtoList(List<Feedback> feedbackList) throws NullPointerException{
        System.out.println("hello " + feedbackList);
        List<FeedbackDto> feedbackDtoList = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            try {
                FeedbackDto feedbackDto = new FeedbackDto();
                feedbackDto.setPid(feedback.getPid());
                feedbackDto.setCorrectionId(feedback.getCorrectionId());
                feedbackDto.setComment(feedback.getComment());
                feedbackDto.setFeedback(feedback.getFeedback());
                feedbackDto.setFinalMark(feedback.getFinalMark());
                feedbackDto.setFlagOutstanding(feedback.getFlagOutstanding());
                feedbackDto.setCorrector(feedback.getCorrector());
                feedbackDto.setCorrected(feedback.getCorrected());
                feedbackDto.setCreatedAt(feedback.getCreatedAt());
                feedbackDto.setProjectId(feedback.getProjectId());
                feedbackDto.setProjectName(feedback.getProjectName());

                feedbackDtoList.add(feedbackDto);
            }
            catch (NullPointerException e){
                return null;
            }
        }
        return feedbackDtoList;
    }


}
