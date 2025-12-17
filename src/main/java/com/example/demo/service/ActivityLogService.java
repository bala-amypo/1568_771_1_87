package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entity.ActivityLog;

public interface ActivityLogService {
    ActivityLog logActivity(long userId,long typeId,ActivityLog log);
    List<ActivityLog> getLogsByUser(long userId);
    List<ActivityLog> getLogsByUserAndDate(long userId,LocalDate start, LocalDate end);
    ActivityLog getLog(long id);
}
