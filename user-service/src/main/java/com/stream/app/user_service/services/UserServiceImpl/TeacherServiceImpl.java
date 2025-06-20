package com.stream.app.user_service.services.UserServiceImpl;

import com.stream.app.user_service.entities.User;
import com.stream.app.user_service.repositories.UserRepo;
import com.stream.app.user_service.services.TokenContextService;
import com.stream.app.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("teacherService")
@RequiredArgsConstructor
public class TeacherServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User getDetails(String email) {

        User user = userRepo.findByEmail(email);


        if(user.getRole().equalsIgnoreCase("admin"))
            return null;
        else
            return user;
    }
}
