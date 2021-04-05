package com.example.demo.context;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
@Data
public class UserSession implements Serializable {
    private Long serialVersionUID = 1322424L;

    String receiveMessage;
    List<String> messages = new ArrayList<>();
}
