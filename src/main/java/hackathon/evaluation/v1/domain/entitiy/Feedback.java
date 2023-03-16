package hackathon.evaluation.v1.domain.entitiy;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Feedback {

    @Id
    private Integer pid;

    @Column(name="correction_id")
    private Integer correctionId;
    private String comment;
    private String feedback;

    @Column(name="final_mark")
    private Integer finalMark;

    @Column(name="flag_outstanding")
    private Boolean flagOutstanding;
    private Integer corrector;
    private Integer corrected;

    @Column(name="created_at")
    private Date createdAt;
    @Column(name="project_id")
    private Integer projectId;
    @Column(name="project_name")
    private String projectName;
}
