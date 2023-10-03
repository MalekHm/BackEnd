package com.backend.hrportal.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CondidatRequest {
    String condidat;
    Long user;
    Long position;
    MultipartFile file;
}
