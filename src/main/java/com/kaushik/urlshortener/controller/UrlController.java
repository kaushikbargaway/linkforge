package com.kaushik.urlshortener.controller;

import com.kaushik.urlshortener.dto.UrlRequest;
import com.kaushik.urlshortener.entity.Url;
import com.kaushik.urlshortener.service.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/api/shorten")
        public ResponseEntity<?> shorten(@RequestBody UrlRequest request) {

                String shortCode = service.createShortUrl(

                        request.getUrl(),
                        request.getCustomAlias(),
                        request.getExpiryDate()

                );

                return ResponseEntity.ok(
                        Map.of(
                                "shortUrl",
                                "http://localhost:8080/" + shortCode
                        )
                );
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        Url url =
                service.getOriginalUrl(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(url.getOriginalUrl()))
                .build();
    }

    @GetMapping("/api/stats/{shortCode}")
    public Url getStats(
            @PathVariable String shortCode) {

        return service.getStats(shortCode);
    }
}