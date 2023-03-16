package hackathon.evaluation.v1.domain.dto;

import lombok.Getter;
import lombok.Setter;

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
    private Integer corrector;
    private Integer corrected;
    private Date createdAt;
    private Integer projectId;
    private String projectName;
}
