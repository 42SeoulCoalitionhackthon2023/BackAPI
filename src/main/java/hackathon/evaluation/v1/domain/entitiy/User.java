package hackathon.evaluation.v1.domain.entitiy;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {

    @Id
    private Integer pid;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="intra_id")
    private String intraId;
    private String image;
    private Date blackhole;
    private Integer level;
}
