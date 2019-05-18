package kim.jungbin.demo.domain.content;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class ContentOverviewChild {
    @Id
    @GeneratedValue
    private Long id;
    private Long contentOverviewId;
    private String name;

    public ContentOverviewChild(Long contentOverviewId, String name) {
        this.contentOverviewId = contentOverviewId;
        this.name = name;
    }
}
