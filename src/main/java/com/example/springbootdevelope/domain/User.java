package com.example.springbootdevelope.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id", updatable = false)
    private Long id;

    @Column(name="email",nullable = true,unique = true)
    private String email;

    @Column(name= "password")
    private String password;

    @Column(name = "nickname",unique = true)
    private String nickname;

    @Builder
    public User(String email, String password,String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // 사용자 이름 변경
    public User update(String nickname){
        this.nickname = nickname;

        return this;
    }




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    // 사용자의 id를 반환
    @Override
    public String getPassword() {
        return password;
    }
    // 사용자의 패스워드 반환
    @Override
    public String getUsername() {
        return email;
    }
    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true; //true -> 만료되지 않음
    }

    //패스워드의 만료 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true; //true-> 잠금되지 않음
    }
    //게정 사용 가능 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true; //만료되지 않음
    }
    //계정이 사용 가능한지 확인
    @Override
    public boolean isEnabled() {
        return true; //사용가능
    }
}
