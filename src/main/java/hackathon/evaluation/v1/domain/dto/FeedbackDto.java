package hackathon.evaluation.v1.domain.dto;

import hackathon.evaluation.v1.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Getter
@Setter
public class FeedbackDto {

    private Integer pid;
    private Integer correctionId;
    private String comment;
    private String feedback;
    private Integer finalMark;
    private Boolean flagOutstanding;
    private String corrector;
    private String corrected;
    private Date createdAt;
    private Integer projectId;
    private String projectName;

//    public void setCorrector(Integer corrector) {
//        this.corrector = userRepository.findByUserId(corrector).getIntraId();
//    }
//
//    public void setCorrected(Integer corrected) {
//        this.corrected = userRepository.findByUserId(corrected).getIntraId();
//    }
}
