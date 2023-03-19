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
@RequestMapping("comment")
public class FeedbackController {

    @Autowired
    private final FeedbackService feedbackService;

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
        return null;  //예외처리 필요
    }

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
        return null;  //예외처리 필요
    }
}
