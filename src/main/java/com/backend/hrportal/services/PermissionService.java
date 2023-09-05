package com.backend.hrportal.services;

import com.backend.hrportal.models.Holiday;
import com.backend.hrportal.models.Permission;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface PermissionService {
    public List<Permission> getList();
    public Permission confirmed( Long id);

    public List<Permission>filterByDate(Date start, Date end);

}