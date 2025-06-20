package com.stream.app.user_service.services.UserServiceImpl;

import com.stream.app.user_service.entities.User;
import com.stream.app.user_service.repositories.UserRepo;
import com.stream.app.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("studentService")
@RequiredArgsConstructor
public class StudentServiceImpl implements UserService {
    
    
    private final UserRepo userRepo;
//    private final TokenContextService;

    @Override
    public User getDetails(String email) {

        User user = userRepo.findByEmail(email);
//        String role = tokenContextService.getRoleFromToken();

        if(!user.getRole().equalsIgnoreCase("student")){
            throw new RuntimeException("invalid role");
        }
        else{
            return user;

        }
    }

}