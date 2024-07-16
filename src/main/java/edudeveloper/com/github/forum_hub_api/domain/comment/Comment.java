package edudeveloper.com.github.forum_hub_api.domain.comment;

import jakarta.persistence.*;
import edudeveloper.com.github.forum_hub_api.domain.topic.Topic;
import edudeveloper.com.github.forum_hub_api.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Table(name = "comments")
@Entity(name = "Answer")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @Column(columnDefinition = "boolean default false")
    private boolean solution;

    public Comment(String text, Topic topic, User user) {
        this.text = text;
        this.topic = topic;
        this.createdAt = LocalDateTime.now();
        this.user = user;
    }

    public void markAsSolution() {
        this.solution = true;
    }
}
