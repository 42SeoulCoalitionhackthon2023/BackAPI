package hackathon.evaluation.v1.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto {
    private Integer pid;
    private Integer user_id;
    private String intra_id;
    private String image;
    private Date blackhole;
    private Integer level;

    public UserDto(Integer pid) {
        this.pid = pid;
    }
}
