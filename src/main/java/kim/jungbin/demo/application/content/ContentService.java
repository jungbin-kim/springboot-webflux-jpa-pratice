package kim.jungbin.demo.application.content;

import kim.jungbin.demo.domain.a.ASystem;
import kim.jungbin.demo.domain.a.AUsingSomeWhere;
import kim.jungbin.demo.domain.content.Content;
import kim.jungbin.demo.domain.content.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    private ASystem aSystem;

    public Mono<Content> get(Long contentId) {
        final Mono<AUsingSomeWhere> aUsingSomeWhereMono = aSystem.getAUsingSomeWhere();

        final Mono<Content> contentMono = Mono.justOrEmpty(contentRepository.findById(contentId));

        return Mono.zip(aUsingSomeWhereMono, contentMono, (aUsingSomeWhere, content) -> {
            return content;
        });
    }
}
