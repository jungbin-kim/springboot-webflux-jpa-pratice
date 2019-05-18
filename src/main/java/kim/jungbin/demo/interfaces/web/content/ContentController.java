package kim.jungbin.demo.interfaces.web.content;


import kim.jungbin.demo.application.content.ContentService;
import kim.jungbin.demo.domain.content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/contents/{contentId}")
    public Mono<Content> getContent(@PathVariable Long contentId) {
        return contentService.get(contentId);
    }
}
