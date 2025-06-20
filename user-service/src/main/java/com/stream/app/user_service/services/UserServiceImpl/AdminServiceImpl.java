package com.stream.app.user_service.services.UserServiceImpl;

import com.stream.app.user_service.entities.User;
import com.stream.app.user_service.repositories.UserRepo;
import com.stream.app.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("adminService")
@RequiredArgsConstructor
@Slf4j
public class AdminServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User getDetails(String email) {
        log.debug("Getting admin details for email: {}", email);

        User user = userRepo.findByEmail(email);
        if (user == null) {
            log.warn("No admin found with email: {}", email);
            return null;
        }

        if (!"admin".equalsIgnoreCase(user.getRole())) {
            log.warn("Access denied: Not an admin: {}", email);
            return null;
        }

        return user;
    }
}

