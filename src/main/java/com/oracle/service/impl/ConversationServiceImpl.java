package com.oracle.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.oracle.dto.request.ChatRequestDTO;
import com.oracle.dto.response.ChatResponseDTO;
import com.oracle.dto.response.ChatResponseMapper;
import com.oracle.model.Message;
import com.oracle.service.ConversationService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConversationServiceImpl implements ConversationService {

    private static final String API_URL = "http://localhost:11434/api/generate";
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper;
    private final List<Message> chatHistory = new ArrayList<>();

    public ConversationServiceImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public ChatResponseDTO sendPrompt(ChatRequestDTO requestDTO) {

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gemma:2b");
        requestBody.put("prompt", requestDTO.getQuestion());
        requestBody.put("stream", false);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(
                requestBody,
                createHeaders()
        );

        try {
            String responseBody = restTemplate.postForObject(API_URL, request, String.class);
            ChatResponseMapper responseMapper = objectMapper.readValue(responseBody, ChatResponseMapper.class);
            return mapToResponseDTO(responseMapper);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error processing JSON response", e);
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ChatResponseDTO mapToResponseDTO(ChatResponseMapper responseMapper) {
        ChatResponseDTO responseDTO = new ChatResponseDTO();
        responseDTO.setResponse(responseMapper.getResponse());
        responseDTO.setModel(responseMapper.getModel());
        return responseDTO;
    }
}