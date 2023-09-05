package com.backend.hrportal.controllers;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Permission;
import com.backend.hrportal.models.Remote;
import com.backend.hrportal.services.PermissionService;
import com.backend.hrportal.services.RemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/all")
    public ResponseEntity<List<Permission>> getAllEmployees() {
        List <Permission> permissions= permissionService.getList();
        return ResponseEntity.ok().body(permissions);
    }
    @GetMapping("/confirmed/{id}")
    public   ResponseEntity<Permission> confirmed(@PathVariable(value = "id") Long id) {
        Permission permission= permissionService.confirmed(id);
        return ResponseEntity.ok().body(permission);
    }
    @GetMapping("/filtreByDate/{start}/{end}")
    public ResponseEntity<List<Permission>> filtreByDate(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            Date end
    ) {
        List <Permission> permissions= permissionService.filterByDate(start,end);
        return ResponseEntity.ok().body(permissions);
    }
}


