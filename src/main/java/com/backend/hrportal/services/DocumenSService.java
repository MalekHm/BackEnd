package com.backend.hrportal.services;

import com.backend.hrportal.models.Document;
import com.backend.hrportal.payload.request.DocumentRequest;
import org.springframework.core.io.Resource;

import java.util.List;

public interface DocumenSService {

    Document saveDocument(DocumentRequest documentRequest);

    Resource load(String filename);

    List<Document> getAll();
}
