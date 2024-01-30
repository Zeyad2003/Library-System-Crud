package com.fawry.librarysystem.model.response;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomResponse {
    private String message;
    private Integer status;
    private String time;
    private Object data;

    public static ResponseEntity<CustomResponse> response(String message, Integer status, Object data) {
        CustomResponse addingBookResponse = new CustomResponse();
        addingBookResponse.setMessage(message);
        addingBookResponse.setStatus(status);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
        String formatDateTime = localDateTime.format(formatter);
        addingBookResponse.setTime(formatDateTime);
        addingBookResponse.setData(data);

        return ResponseEntity.ok(addingBookResponse);
    }

}
