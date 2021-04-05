package com.example.demo.controller;

import com.example.demo.context.UserSession;
import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Controller
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final UserSession userSession;
    private final MessageRedisRepository messageRedisRepository;

    @GetMapping({"/index", "/get", "/"})
    public String getIndex(Model model) {
        model.addAttribute("test", "initial value");
        return "test";
    }

    @PostMapping("/index")
    public String postIndex(Model model, @RequestParam("test") String text) {

        log.info("before value:{}", text);
        Long id = Math.round(Math.random() * 1000000);
        Message message = new Message(id, text);
        messageRedisRepository.save(message);
        log.info("id :{}", id);

        userSession.setReceiveMessage(text);
        userSession.getMessages().add(text);

        model.addAttribute("messages", List.of("id:" + id + ", message:" + text));

        return "test";
    }

    @PostMapping("/get")
    public String postGet(Model model, @RequestParam("id") Long id) {
        Optional<Message> message = messageRedisRepository.findById(id);
        message.ifPresent(value -> model.addAttribute("messages", List.of(
                id + ":" + value.getMessage()
        )));
        return "test";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        Iterable<Message> messages = messageRedisRepository.findAll();
        List<String> list = Stream.of(messages)
                .flatMap(e -> StreamSupport.stream(e.spliterator(), false))
                .map(e -> e.getId() + ":" + e.getMessage()).collect(Collectors.toList());
        model.addAttribute("messages", list);
        return "test";
    }
}
