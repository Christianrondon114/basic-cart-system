package com.christianrondon.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class CustomErrorResponse {
    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<String> details;
}
