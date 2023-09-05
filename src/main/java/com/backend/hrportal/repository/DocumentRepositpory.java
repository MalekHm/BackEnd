package com.backend.hrportal.repository;

import com.backend.hrportal.models.Document;
import com.backend.hrportal.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.Doc;

public interface DocumentRepositpory extends JpaRepository<Document, Long> {
}
