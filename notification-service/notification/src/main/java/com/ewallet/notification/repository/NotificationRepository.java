package com.ewallet.notification.repository;

import com.ewallet.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<NotificationLog, Long> {
}
