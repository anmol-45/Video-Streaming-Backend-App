package com.stream.app.user_service.services.UserServiceImpl;

import com.stream.app.user_service.entities.User;
import com.stream.app.user_service.repositories.UserRepo;
import com.stream.app.user_service.services.TokenContextService;
import com.stream.app.user_service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("adminService")
@RequiredArgsConstructor
public class AdminServiceImpl implements UserService {


    private final UserRepo userRepo;
//    private final TokenContextService;

    @Override
    public User getDetails(String email) {

        return userRepo.findByEmail(email);

    }
}
