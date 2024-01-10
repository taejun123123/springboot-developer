package com.example.springbootdevelope.service;

import com.example.springbootdevelope.domain.User;
import com.example.springbootdevelope.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    //사용자 이름으로 사용자의 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String email) {
            return userRepository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException((email)));

    }
}