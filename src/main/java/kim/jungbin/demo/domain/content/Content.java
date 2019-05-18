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
public class Content {
    @Id
    private Long id;
    private String name;
    /*
    * JoinColumn
    * - name: join 대상 entity에 있는 column 이름
    * - referencedColumnName: 현재 entity에서 참조할 column 이름
    * */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "contentId", referencedColumnName = "id")
    private Collection<ContentOverview> contents;

    public Content(String name) {
        this.name = name;
    }
}
