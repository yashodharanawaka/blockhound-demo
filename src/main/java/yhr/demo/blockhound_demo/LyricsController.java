package yhr.demo.blockhound_demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lyrics")
@RequiredArgsConstructor
public class LyricsController {
    private final LyricsService lyricsService;

    @GetMapping("/reactive")
    public Mono<String> getReactiveLyrics(@RequestParam String artist, @RequestParam String title) {
        return lyricsService.fetchLyricsReactive(artist, title);
    }

    @GetMapping("/blocking")
    public Mono<String> getBlockingLyrics(@RequestParam String artist,@RequestParam String title) {
        return Mono.just(lyricsService.fetchLyricsBlocking(artist, title));
    }
}
