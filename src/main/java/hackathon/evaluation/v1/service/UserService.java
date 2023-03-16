package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public UserDto getUserDto(Integer id) {
//        UserDto userDto = new UserDto(id);
//        return userDto;
//    }

    public User getUserInfo(String intraId) {
        User userData = userRepository.findByIntraId(intraId);
        UserDto userInfo = new UserDto();
        userInfo.setPid(userData.getPid());
        userInfo.setUserId(userData.getUserId());
        userInfo.setBlackhole(userData.getBlackhole());
        userInfo.setLevel(userData.getLevel());
        userInfo.setImage(userData.getImage());
        return userData;
    }
}
