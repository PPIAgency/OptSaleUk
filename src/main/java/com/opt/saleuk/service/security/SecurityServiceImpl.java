package com.opt.saleuk.service.security;

import com.opt.saleuk.dao.user.UserDAO;
import com.opt.saleuk.model.user.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SecurityServiceImpl implements SecurityService {

    private static final Logger LOG = Logger.getLogger(SecurityServiceImpl.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean cryptUserPass(User user) {
        if (null!=user && null!=user.getPassword()){
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            return true;
        }
        return false;
    }

    @Override
    public boolean isPasswordMatchEncrypted(String raw, String encoded) {
        return bCryptPasswordEncoder.matches(raw, encoded);
    }

    @Override
    public long getAuthenticatedUserIdByEmail(String email){
        User user = userDAO.findByEmail(email);
        return user.getId();
    }

    @Override
    public boolean autoLogin(String login, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(login);
        String encodedPassword = bCryptPasswordEncoder.encode(password);

        Collection<? extends GrantedAuthority> authorities;

        if(userDetails != null && userDetails.getAuthorities() != null){
            authorities = userDetails.getAuthorities();
        } else {
            authorities = null;
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, authorities);

        authenticationManager.authenticate(authenticationToken);

        if (authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            return true;
        } else {
            return false;
        }
    }
}
