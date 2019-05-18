package kim.jungbin.demo.infrastructure.api.aImpl;

import kim.jungbin.demo.domain.a.ASystem;
import kim.jungbin.demo.domain.a.AUsingSomeWhere;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Service
@Slf4j // annotation을 사용함으로 log 변수를 사용할 수 있게 한다.
public class ASystemImpl implements ASystem {

    private WebClient webClient;
    private final static String domain = "http://localhost:8080";

    public ASystemImpl() {
        this.webClient = WebClient.builder()
                .baseUrl(this.domain)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .filter(logRequest())
                .build();
    }

    @Override
    public Mono<AUsingSomeWhere> getAUsingSomeWhere() {
        return webClient.get()
                .uri("/outside/system/a")
                .accept(APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(AUsingSomeWhere.class));
    }

    // https://www.callicoder.com/spring-5-reactive-webclient-webtestclient-examples/
    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("{}={}", name, value)));
            return Mono.just(clientRequest);
        });
    }
}
