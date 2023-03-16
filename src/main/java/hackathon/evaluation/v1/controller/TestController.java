package hackathon.evaluation.v1.controller;
import hackathon.evaluation.v1.Dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    @GetMapping()
    TestDto test() {
        TestDto greeting = new TestDto();
        greeting.setText("hello world");

        return greeting;
    }
}
