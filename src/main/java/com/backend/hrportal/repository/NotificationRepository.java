package com.backend.hrportal.repository;

import com.backend.hrportal.models.Notification;
import com.backend.hrportal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    @Query("SELECT n FROM Notification n WHERE n.user.id = :id ")
    List<Notification> listNotification(@Param("id") Long id);



    @Query("SELECT n FROM Notification n WHERE  n.vu = false  and n.user.id = :id ")
    List<Notification> findNotificationByUserId(@Param("id") Long id);

}
