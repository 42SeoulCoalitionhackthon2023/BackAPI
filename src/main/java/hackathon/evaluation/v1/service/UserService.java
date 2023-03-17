package hackathon.evaluation.v1.service;

import hackathon.evaluation.v1.domain.dto.UserDto;
import hackathon.evaluation.v1.domain.entitiy.User;
import hackathon.evaluation.v1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Component
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDto getUserInfo(String intraId) {
        User userData = userRepository.findByIntraId(intraId);
        return getUserDto(userData);
    }

    private static UserDto getUserDto(User userData) throws NullPointerException{
        UserDto userDto = new UserDto();
        try {
            userDto.setPid(userData.getPid());
            userDto.setUserId(userData.getUserId());
            userDto.setIntraId(userData.getIntraId());
            userDto.setBlackhole(userData.getBlackhole());
            userDto.setLevel(userData.getLevel());
            userDto.setImage(userData.getImage());}
        catch (NullPointerException e){
            return null;
        }
        return userDto;
    }
}
