package hackathon.evaluation.v1.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.evaluation.v1.domain.dto.TestDto;
import hackathon.evaluation.v1.service.FeedbackService;
import hackathon.evaluation.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test4")
public class TestController4 {

    @Autowired
    private UserService userService;
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping()
    TestDto test() throws JsonProcessingException {
        TestDto greeting = new TestDto();
        greeting.setText("hello world" + userService.getUserInfoById(3198).getIntraId());

        return greeting;
    }
}
