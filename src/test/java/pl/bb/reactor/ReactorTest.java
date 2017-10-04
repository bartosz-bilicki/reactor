package pl.bb.reactor;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class ReactorTest {
    private static final Logger LOG= LoggerFactory.getLogger(ReactorTest.class);

    @Test
    public void should() {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        seq1.bufferTimeout(2, Duration.of(1, ChronoUnit.SECONDS))
                .subscribe(System.out::println);
    }

    @Test
    public void shouldTime() throws InterruptedException {
        Flux.interval(Duration.ofMillis(10))
                .bufferTimeout(10,Duration.ofMillis(30))
                .subscribe(System.out::println);
        Thread.sleep(500);
    }
}
