package com.oracle.api;

import com.oracle.dto.request.ChatRequestDTO;
import com.oracle.dto.response.ChatResponseDTO;
import com.oracle.service.ConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/oracle")
public class OracleController {

    @Autowired
    ConversationService service;

    @GetMapping
    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello from Oracle!");
    }

    @PostMapping
    @RequestMapping("/chat")
    public ResponseEntity<ChatResponseDTO> chat(@RequestBody ChatRequestDTO request){
        ChatResponseDTO ret = service.sendPrompt(request);
        return ResponseEntity.ok(ret);
    }
}
