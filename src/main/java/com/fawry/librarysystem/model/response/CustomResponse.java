package com.fawry.librarysystem.model.response;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CustomResponse {
    private String message;
    private int status;
    private String time;

    public CustomResponse() {}

    public static ResponseEntity<CustomResponse> response(String message) {
        CustomResponse addingBookResponse = new CustomResponse();
        addingBookResponse.setMessage(message);
        addingBookResponse.setStatus(200);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss a");
        String formatDateTime = localDateTime.format(formatter);
        addingBookResponse.setTime(formatDateTime);

        return ResponseEntity.ok(addingBookResponse);
    }
}
