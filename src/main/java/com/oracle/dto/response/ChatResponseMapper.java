package com.oracle.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
public class ChatResponseMapper {
    private String model;
    private ZonedDateTime created_at;
    private String response;
    private boolean done;
    private String done_reason;
    private List<Integer> context;
    private long total_duration;
    private long load_duration;
    private int prompt_eval_count;
    private long prompt_eval_duration;
    private int eval_count;
    private long eval_duration;
}