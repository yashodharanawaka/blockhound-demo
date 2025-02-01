package yhr.demo.blockhound_demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.blockhound.BlockHound;

@SpringBootTest
class LyricsServiceTest {
    @BeforeAll
    static void setup() {
        BlockHound.install();
    }

    @Autowired
    LyricsService lyricsService;

    @Test
    void shouldDetectBlockingInReactiveMethod() {
        lyricsService.fetchLyricsReactive("coldplay", "yellow");
    }

    @Test
    void shouldDetectBlockingCallInRestTemplate() {
        lyricsService.fetchLyricsBlocking("coldplay", "yellow");
    }
}