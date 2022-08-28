package com.github.repository.reader.reporeader.Github.Api.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiError {
    private String status;
    private String Message;
}
