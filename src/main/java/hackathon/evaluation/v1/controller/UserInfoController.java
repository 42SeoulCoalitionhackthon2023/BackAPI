package hackathon.evaluation.v1.controller;

import hackathon.evaluation.v1.domain.dto.UserDto;
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

    /*
    user정보 API(/user/{intraId}) example : http://13.209.130.135/user/gehan
    - Return type : json
    - {
        "pid":271,
        "userId":135416,
        "intraId":"gehan",
        "image":"https://cdn.intra.42.fr/users/7b812d6295638cb4ab865e282a66ca82/small_gehan.jpg",
        "blackhole":"2023-08-20T15:00:00.000+00:00",
        "level":85,
        "outstandingRate":null}
     */
//    @GetMapping("/{intraId}")
//    public UserDto userInformation(@PathVariable String intraId) {
//        return userService.getUserInfo(intraId);
//    }

    @GetMapping("/{intraId}")
    public ResponseEntity<UserDto> userInformation(@PathVariable String intraId) {
        UserDto userDto = userService.getUserInfo(intraId);
        if (userDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(userDto);
    }


}
