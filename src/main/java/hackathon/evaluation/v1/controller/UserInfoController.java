package hackathon.evaluation.v1.controller;

import hackathon.evaluation.v1.domain.dto.FeedbackDto;
import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.service.FeedbackService;
import hackathon.evaluation.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;
    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/{intraId}")
    public ResponseEntity<UserDto> userInformation(@PathVariable String intraId) {
        UserDto userDto = userService.getUserInfo(intraId);
        if (userDto == null) {
            return ResponseEntity.badRequest().build();
        }
        userDto.setCircle(feedbackService.getUserCircle(userDto.getUserId()));
        return ResponseEntity.ok(userDto);
    }


}
