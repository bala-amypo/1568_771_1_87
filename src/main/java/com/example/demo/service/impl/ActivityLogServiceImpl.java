package com.example.demo.service.impl;

import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ActivityLogService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository logRepository;
    private final UserRepository userRepository;
    private final ActivityTypeRepository typeRepository;

    public ActivityLogServiceImpl(ActivityLogRepository logRepository, UserRepository userRepository, ActivityTypeRepository typeRepository) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
    }

    @Override
    public ActivityLog logActivity(long userId, long typeId, ActivityLog log) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        ActivityType type = typeRepository.findById(typeId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found"));
        log.setUser(user);
        log.setActivityType(type);
        return logRepository.save(log);
    }

    @Override
    public ActivityLog getLog(long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity log not found"));
    }

    @Override
    public List<ActivityLog> getLogsByUser(long userId) {
        return logRepository.findByUser_Id(userId);
    }

    @Override
    public List<ActivityLog> getLogsByUserAndDate(long userId, LocalDate start, LocalDate end) {
        return logRepository.findByUser_IdAndActivityDateBetween(userId, start, end);
    }
}
