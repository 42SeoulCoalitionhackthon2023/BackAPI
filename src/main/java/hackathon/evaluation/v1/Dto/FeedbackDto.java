package hackathon.evaluation.v1.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FeedbackDto {
    private Integer correction_id;
    private String comment;
    private String feedback;
    private Integer final_mark;
    private Boolean flag_outstanding;
    private Integer corrector;
    private Integer corrected;
    private Date created_at;
    private Integer project_id;
    private String project_name;
}
