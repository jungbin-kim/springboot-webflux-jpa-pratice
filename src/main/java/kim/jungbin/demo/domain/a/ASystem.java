package kim.jungbin.demo.domain.a;

import reactor.core.publisher.Mono;

/*
* A라는 외부 시스템을 표현하는 도메인
* 예) message 서비스
* 인터페이스로 선언되어 있어 A 시스템에 대한 명세를 가진다.
* 명세는 어플리케이션 내에서 사용될 A 시스템의 기능들과 객체로 표현된다.
* 실제 구현체는 domain package 외부인 infrastructure package 에 존재.
* */
public interface ASystem {
    Mono<AUsingSomeWhere> getAUsingSomeWhere();
}
