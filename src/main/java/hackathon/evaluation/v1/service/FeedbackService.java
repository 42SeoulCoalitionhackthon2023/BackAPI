package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.Subject;
import hackathon.evaluation.v1.domain.dto.FeedbackDto;
import hackathon.evaluation.v1.domain.dto.CircleDto;
import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.Feedback;
import hackathon.evaluation.v1.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Component
@RequiredArgsConstructor
public class FeedbackService {

    @Autowired
    private final FeedbackRepository feedbackRepository;
    @Autowired
    private UserService userService;
    private final Subject subject = new Subject();

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
    public List<FeedbackDto> getCommentByCircle(Integer corrector, Integer circle){
        List<Feedback> feedback = new ArrayList<>();
        Arrays.stream(subject.subjectList.get(circle).split("/"))
                .iterator()
                .forEachRemaining((each_subject) -> feedback.addAll(feedbackRepository
                        .findByCorrectorAndProjectNameOrderByCreatedAtDesc(corrector, each_subject)));
        return getFeedbackDtoList(feedback);
    }

    @Transactional
    public List<FeedbackDto> getCommentOfCircle(Integer corrected, Integer circle){
        List<Feedback> feedback = new ArrayList<>();
        Arrays.stream(subject.subjectList.get(circle).split("/"))
                .iterator()
                .forEachRemaining((each_subject) -> feedback.addAll(feedbackRepository
                        .findByCorrectedAndProjectNameOrderByCreatedAtDesc(corrected, each_subject)));
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

    public Integer getUserCircle(Integer userId) {
        Feedback feedback = feedbackRepository.findFirstByCorrectedOrderByCreatedAtDesc(userId);
        Integer circle = 0;
        circle = subject.subjectList.entrySet().stream()
                .filter(entry -> entry.getValue().contains(feedback.getProjectName()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        return circle;
    }

    public String getIntraId(Integer userId){
        try {
            UserDto userInfo = userService.getUserInfoById(userId);
            return userInfo.getIntraId();
        }
        catch (NullPointerException e){
            return "Anonymous";
        }
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
                continue;
            }
        }
        return feedbackDtoList;
    }


    public CircleDto getCircleDto(Feedback feedback) throws NullPointerException{
            CircleDto circleDto = new CircleDto();
            try {
                circleDto.setCircle(getUserCircle(feedback.getCorrected()));
            }
            catch (NullPointerException e){
                circleDto.setCircle(0);
            }
            return circleDto;
        }


}
