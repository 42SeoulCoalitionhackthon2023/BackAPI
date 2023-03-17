package hackathon.evaluation.v1.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.evaluation.v1.domain.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "http://121.135.181.61:8080")
@RestController
@RequiredArgsConstructor
@RequestMapping("/test2")
public class TestController2 {

    private final ObjectMapper objectMapper;

    @GetMapping()
    TestDto test() throws JsonProcessingException {
        TestDto greeting = new TestDto();
        greeting.setText("hello world");

        return greeting;
    }
}
