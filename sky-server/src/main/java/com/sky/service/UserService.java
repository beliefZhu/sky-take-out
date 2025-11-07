package com.sky.service;

import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User wxLogin(@RequestBody UserLoginDTO userLoginDTO);
}
