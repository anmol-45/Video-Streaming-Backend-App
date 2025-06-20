package com.stream.app.user_service.controllers;

import com.stream.app.user_service.entities.User;
import com.stream.app.user_service.services.UserServiceImpl.AdminServiceImpl;
import com.stream.app.user_service.services.UserServiceImpl.StudentServiceImpl;
import com.stream.app.user_service.services.UserServiceImpl.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final StudentServiceImpl studentService;
    private final TeacherServiceImpl teacherService;
    private final AdminServiceImpl adminService;

    @GetMapping("/student/{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<User> getStudentDetails(@PathVariable String id) {
        return ResponseEntity.ok(studentService.getDetails(id));
    }

    @GetMapping("/teacher/{id}")
    @PreAuthorize("hasRole('TEACHER')")
    public ResponseEntity<User> getTeacherDetails(@PathVariable String id) {
        return ResponseEntity.ok(teacherService.getDetails(id));
    }

    @GetMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> getUserDetails(@PathVariable String id) {
        return ResponseEntity.ok(adminService.getDetails(id));
    }

}
