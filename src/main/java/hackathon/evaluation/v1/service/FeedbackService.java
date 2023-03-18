package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.dto.FeedbackDto;
import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.Feedback;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.repository.FeedbackRepository;
import hackathon.evaluation.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Component
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    private final FeedbackRepository feedbackRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public List<FeedbackDto> getCommentBy(Integer corrector){
        List<Feedback> feedback = feedbackRepository.findByCorrectorOrderByCreatedAtDesc(corrector);
        return getFeedbackDtoList(feedback);
    }

    @Transactional
    public List<FeedbackDto> getCommentOf(Integer corrected){
        List<Feedback> feedback = feedbackRepository.findByCorrectedOrderByCreatedAtDesc(corrected);
        return getFeedbackDtoList(feedback);
    }

    @Transactional
    public List<FeedbackDto> getCommentByCorrectorProjectName(Integer corrector, String projectName){
        List<Feedback> feedback = feedbackRepository.findByCorrectorAndProjectNameOrderByCreatedAtDesc(corrector, projectName);
        return getFeedbackDtoList(feedback);
    }

    @Transactional
    public List<FeedbackDto> getCommentByCorrectedProjectName(Integer corrected, String projectName){
        List<Feedback> feedback = feedbackRepository.findByCorrectedAndProjectNameOrderByCreatedAtDesc(corrected, projectName);
        return getFeedbackDtoList(feedback);
    }

    public String getIntraId(Integer userId){
        UserDto example = userService.getUserInfoById(userId);
        return example.getIntraId();
    }

    public List<FeedbackDto> getFeedbackDtoList(List<Feedback> feedbackList) throws NullPointerException{
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
                feedbackDto.setCorrector(getIntraId(feedback.getCorrector()));
                feedbackDto.setCorrected(getIntraId(feedback.getCorrected()));
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
