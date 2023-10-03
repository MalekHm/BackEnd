package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Document;
import com.backend.hrportal.payload.request.DocumentRequest;
import com.backend.hrportal.services.DocumentService;
import com.backend.hrportal.services.impl.DocumentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/document")
public class DocumentController {
    @Autowired
    private DocumentServiceI documentServiceI;
    @PostMapping("/upload")
    public ResponseEntity<Document> uploadFile(@ModelAttribute DocumentRequest documentRequest) {
        return ResponseEntity.status(HttpStatus.OK).body( documentServiceI.saveDocument(documentRequest));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Document>> getAll( ) {
        return ResponseEntity.status(HttpStatus.OK).body( documentServiceI.getAll());
    }
    @GetMapping("/downloadFile/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws IOException {
        Resource file = documentServiceI.load(filename);
        Path path = file.getFile()
                .toPath();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
