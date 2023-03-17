package hackathon.evaluation.v1.controller;

import hackathon.evaluation.v1.domain.dto.FeedbackDto;
import hackathon.evaluation.v1.domain.entitiy.Feedback;
import hackathon.evaluation.v1.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class FeedbackController {

    @Autowired
    private final FeedbackService feedbackService;

    /*
        1. feedback data by userId(/comment/{type}={userId})
        - {type} - String : "corrector", "corrected"
            corrector(평가한 것) example : http://13.209.130.135/comment/corrector=135416
            corrected(평가받은 것) example : http://13.209.130.135/comment/corrected=135416
        - {userId} - Integer : userId (주의!! intraId 아님)
        - Return type : json Array
        - [{
            "pid":18984,
            "correctionId":5116560,
            "comment":"cpp 과제 평가를 많이 다녀봤지만 ....",
            "feedback":"평가자분께서 cpp 및 객체 지향을 ....",
            "finalMark":90,
            "flagOutstanding":true,
            "corrector":135416,
            "corrected":103895,
            "createdAt":"2023-02-25T18:39:36.000+00:00",
            "projectId":1341,
            "projectName":"cpp-03"
           }, ...]
         */
    @GetMapping("/{type}={userId}")
    public List<FeedbackDto> commentById(
            @PathVariable String type,
            @PathVariable Integer userId)
    {
        if (type.equals("corrector")) {
            return feedbackService.getCommentBy(userId);
        } else if (type.equals("corrected")) {
            return feedbackService.getCommentOf(userId);
        }
        return null;
    }

    /*
        2. feedback data by projectName(/comment/{type}={userId}/{projectName})
        - {type} - String : "corrector", "corrected"
        - {userId} - Integer : userId (주의!! intraId 아님)
        - {projectName} - String : "과제이름"
        - Return type : json Array
     */
    @GetMapping("/{type}={userId}/{projectName}")
    public List<FeedbackDto> commentByProjectName(
            @PathVariable String type,
            @PathVariable Integer userId,
            @PathVariable String projectName)
    {
        if (type.equals("corrector")) {
            return feedbackService.getCommentByCorrectorProjectName(userId, projectName);
        } else if (type.equals("corrected")) {
            return feedbackService.getCommentByCorrectedProjectName(userId, projectName);
        }
        return null;
    }
}
