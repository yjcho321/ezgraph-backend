package yjcho.ezgraph.app.content;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import yjcho.ezgraph.app.user.AppUser;
import yjcho.ezgraph.app.dataset.DataSet;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "UserContents")
public class UserContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ContentType type;

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser user;

    @Column(columnDefinition = "TEXT")
    private String template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "data_set_id", referencedColumnName = "id")
    private DataSet dataSet;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;
}
