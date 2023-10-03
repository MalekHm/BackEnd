package com.backend.hrportal.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequest {
    String title;
    String description;
    String approyedDate;
    String expirationDate;

    String codePolicy;
    String type;

    MultipartFile file;

}
