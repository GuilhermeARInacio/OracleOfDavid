package com.oracle.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatResponseDTO {
    private String response;
    private String model;
}
