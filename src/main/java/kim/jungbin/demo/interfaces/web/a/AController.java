package kim.jungbin.demo.interfaces.web.a;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;

/*
    테스트를 위한 외부 서비스 접근점 선언.
    실제로는 외부에 있는 시스템을 대신함.
 */
@RestController
public class AController {

    @GetMapping("/outside/system/a")
    public Mono<String> getA(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return Mono.just("{ \"result\": \"a\" }");
    }
}
