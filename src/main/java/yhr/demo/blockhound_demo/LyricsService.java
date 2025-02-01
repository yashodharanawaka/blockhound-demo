package yhr.demo.blockhound_demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LyricsService {
    public static final String BASE_URL = "https://api.lyrics.ovh/v1";
    private final WebClient webClient =  WebClient.builder().baseUrl(BASE_URL).build();
    private final RestTemplate restTemplate = new RestTemplate();

    public Mono<String> fetchLyricsReactive(String artist, String title) {
        return webClient.get()
                .uri("/"+artist+"/"+title)
                .retrieve()
                .bodyToMono(String.class);
    }

    public String fetchLyricsBlocking(String artist, String title) {
        String url = "https://api.lyrics.ovh/v1/" + artist + "/" + title;
        return restTemplate.getForObject(url, String.class);
    }
}
