package hackathon.evaluation.v1.controller;

import hackathon.evaluation.v1.Dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private final UserService userService;

    @GetMapping("/{intraId}")
    public String userInformation(@PathVariable String intraId) {
        System.out.println("hello " + userService.getUserInfo(intraId));
        return "hello " + userService.getUserInfo(intraId);
    }
}
