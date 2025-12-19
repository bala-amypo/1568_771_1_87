package com.example.demo.service;

import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;

public interface ActivityLogService {
    ActivityLog logActivity(long userId, long typeId, ActivityLog log);
    ActivityLog getLog(long id);
    List<ActivityLog> getLogsByUser(long userId);
    List<ActivityLog> getLogsByUserAndDate(long userId, LocalDate start, LocalDate end);
}
