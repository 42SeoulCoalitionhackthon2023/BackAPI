package hackathon.evaluation.v1.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto {

    private Integer pid;
    private Integer userId;
    private String intraId;
    private String image;
    private Date blackhole;
    private Integer level;
    private Integer outstandingRate;
}
