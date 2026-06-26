package com.kaushik.urlshortener.service;

import com.kaushik.urlshortener.entity.Url;
import com.kaushik.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;
import com.kaushik.urlshortener.exception.AliasAlreadyExistsException;
import com.kaushik.urlshortener.exception.UrlNotFoundException;

import java.util.UUID;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public String createShortUrl(String originalUrl, String customAlias) {

        String shortCode;

        if (customAlias != null && !customAlias.isBlank()) {

            if (repository.existsByShortCode(customAlias)) {
                throw new AliasAlreadyExistsException("Alias already exists");
            }

            shortCode = customAlias;

        } else {

            do {
                shortCode = UUID.randomUUID()
                    .toString()
                    .substring(0, 6);
            } while (repository.existsByShortCode(shortCode));

        }

        Url url = new Url();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(shortCode);

        repository.save(url);

        return shortCode;
    }

    public Url getOriginalUrl(String shortCode) {

        Url url = repository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException("URL not found"));

        url.setClickCount(url.getClickCount() + 1);

        repository.save(url);

        return url;
    }

    public Url getStats(String shortCode) {

        return repository.findByShortCode(shortCode)
                .orElseThrow(() -> new UrlNotFoundException("URL not found"));
    }
}