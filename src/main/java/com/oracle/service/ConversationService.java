package com.oracle.service;

import com.oracle.dto.request.ChatRequestDTO;
import com.oracle.dto.response.ChatResponseDTO;

public interface ConversationService {

    /* * Sends a chat prompt to the conversation service and returns the response.
     *
     * @param requestDTO The request data transfer object containing the chat prompt.
     * @return A ChatResponseDTO containing the response from the conversation service.
     */
    ChatResponseDTO sendPrompt(ChatRequestDTO requestDTO);
}
