package com.example.demo.controller;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService logService;

    public ActivityLogController(ActivityLogService logService) {
        this.logService = logService;
    }

    @PostMapping("/{userId}/{typeId}")
    public ActivityLog logActivity(@PathVariable long userId, @PathVariable long typeId, @RequestBody ActivityLog log) {
        return logService.logActivity(userId, typeId, log);
    }

    @GetMapping("/{id}")
    public ActivityLog getLog(@PathVariable long id) {
        return logService.getLog(id);
    }

    @GetMapping("/user/{userId}")
    public List<ActivityLog> getLogsByUser(@PathVariable long userId) {
        return logService.getLogsByUser(userId);
    }

    @GetMapping("/user/{userId}/range")
    public List<ActivityLog> getLogsByUserAndDate(
            @PathVariable long userId,
            @RequestParam LocalDate start,
            @RequestParam LocalDate end) {
        return logService.getLogsByUserAndDate(userId, start, end);
    }
}
