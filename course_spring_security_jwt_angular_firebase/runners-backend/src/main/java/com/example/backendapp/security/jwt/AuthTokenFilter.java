package com.example.backendapp.security.jwt;

import com.example.backendapp.security.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// In this class we are validating the JWT that we are getting from Header, exacly from Client(Browser), when the
//use tries to login it sends jwt token that needs to be validated first
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);



    // here we are validating Jwt token for user and also
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = parseJwt(request);
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                // if is when the user wants to acces to some data
                String username = jwtUtils.getUsernameFromJwtToken(jwt);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username); // we use this object to Authenticate
                // we get the user details from UserDetails service, and now this object is ready to validate
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()); // UsernamePasswordAuthenticationToken is used to authenticate the UserDetails object
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); // We use set details to ad the details from the request
                SecurityContextHolder.getContext().setAuthentication(authentication); // now the authentication and all the details about user are put into the security Context, and if we want to get UserDetails we should use SecurityCOntext
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication : {}", e);
        }
        filterChain.doFilter(request,response);

    }

    // this is to get the jwt from request Authorization Header, and then remove the Bearer prefix
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        // In the header we have authorization, and we get the jwt from the header
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7,headerAuth.length()); // we are removing Bearer from header
        }
        return null;
    }
}
