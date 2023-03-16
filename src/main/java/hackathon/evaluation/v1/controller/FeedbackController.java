package hackathon.evaluation.v1.controller;

import hackathon.evaluation.v1.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class FeedbackController {

    @Autowired
    private final FeedbackService feedbackService;

    @GetMapping("/corrector={corrector}")
    public String correctingComment(@PathVariable Integer corrector){
        return "hello " + feedbackService.getFeedbackFrom(corrector);
    }

    @GetMapping("/corrected={corrected}")
    public String correctedComment(@PathVariable Integer corrected){
        return "hello " + feedbackService.getFeedbackOf(corrected);
    }
}
