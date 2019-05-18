package kim.jungbin.demo.domain.content;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class ContentOverview {

    @Id
    @GeneratedValue
    private Long id;
    private Long contentId;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contentOverviewId", referencedColumnName = "id")
    private Collection<ContentOverviewChild> contentOverviewChild;

    public ContentOverview(Long contentId, String name) {
        this.contentId = contentId;
        this.name = name;
    }
}
