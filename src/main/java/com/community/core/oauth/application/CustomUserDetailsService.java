package com.community.core.oauth.application;

import com.community.core.error.dto.ErrorMessage;
import com.community.core.error.exception.member.NotFoundUserException;
import com.community.core.member.domain.User;
import com.community.core.member.infrastructure.UserRepository;
import com.community.core.oauth.domain.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserId(username);
        if (user == null) {
            throw new NotFoundUserException(ErrorMessage.NOT_FIND_ID_USER);
        }
        return UserPrincipal.create(user);
    }
}