package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.Dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        User userInfo = userRepository.findByIntraId(intraId);
        return userInfo;
    }
}
