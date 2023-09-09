package ru.kubzay.restgatewayapi.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.kubzay.restgatewayapi.services.word.WordService;
import ru.kubzay.restgatewayapi.storage.syllable.ParsedWordResult;

import java.util.LinkedList;

@RestController
@RequestMapping("${paths.api}")
public class WordController {

    private WordService service;

    private LinkedList<ParsedWordResult> parsedList;

    @Autowired
    public WordController(WordService service) {
        this.service = service;
    }

    @GetMapping(path = "/word",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    LinkedList<ParsedWordResult> parse(@RequestBody final String word) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            parsedList = this.service.parseOneWord(word);
        } catch (Exception e) {
            //todo log что-то случилось во время парсинга
        }
        if (auth != null && auth.isAuthenticated()) {
            return parsedList;
        } else {
            return new LinkedList<>();
        }
    }
}
