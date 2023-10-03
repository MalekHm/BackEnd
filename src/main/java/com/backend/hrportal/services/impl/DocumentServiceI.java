package com.backend.hrportal.services.impl;

import com.backend.hrportal.models.Document;
import com.backend.hrportal.payload.request.DocumentRequest;
import com.backend.hrportal.repository.DocumentRepositpory;
import com.backend.hrportal.services.DocumenSService;
import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.UrlResource;


@Service
public class DocumentServiceI implements DocumenSService {
    @Autowired
    private DocumentRepositpory documentRepositpory;

    private final Path root = Paths.get("./uploads");

    @Override
    public Document saveDocument(DocumentRequest documentRequest) {
        if (!Files.exists(root)) {
            try {
                Files.createDirectories(root);
            } catch (IOException e) {
                throw new RuntimeException("Could not initialize folder for upload!");
            }
        }
        try {
            Files.copy(documentRequest.getFile().getInputStream(),
                    this.root.resolve(documentRequest.getFile().getOriginalFilename()));
            Document document = new Document(documentRequest.getTitle(), documentRequest.getDescription(),
                    documentRequest.getExpirationDate(), documentRequest.getApproyedDate(),
                    documentRequest.getCodePolicy(), documentRequest.getType(), documentRequest.getFile().getOriginalFilename()
            );
            documentRepositpory.save(document);
            return document;
        } catch (Exception e) {
            if (e instanceof FileAlreadyExistsException) {
                throw new RuntimeException("A file of that name already exists.");
            }

            throw new RuntimeException(e.getMessage());
        }

    }
    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Document> getAll() {
        return documentRepositpory.findAll();
    }
}
