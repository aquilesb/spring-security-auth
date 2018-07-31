package com.realestate.properties.controller;

import com.realestate.properties.config.security.JwtTokenProvider;
import com.realestate.properties.domain.User;
import com.realestate.properties.dto.*;
import com.realestate.properties.helper.DTOConverter;
import com.realestate.properties.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;


@RestController
@RequestMapping("/oauth")
public class AuthController extends BaseRestController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    TokenService tokenService;

    @Autowired
    DTOConverter dtoConverter;

    /**
     * Get token by username and password through the json
     * @param loginRequest form with username and password
     * @return JwtAuthenticationResponse with token
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws UnsupportedEncodingException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        User user = (User) authentication.getPrincipal();
        RedisUser redisUser = dtoConverter.convertUser2Redis(user);
        tokenService.insertToken(jwt, redisUser);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    /**
     * Check if token is valid and exist in redis
     * @param user authenticated user
     * @return JwtAuthenticationResponse with token
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/token")
    public ResponseEntity<?> getToken(@AuthenticationPrincipal User user, HttpServletRequest request) throws UnsupportedEncodingException {
        String token = getJwtFromRequest(request);
        RedisUser redisUser = dtoConverter.convertUser2Redis(user);
//        tokenService.insertToken(token, redisUser);
        if(tokenService.findToken(token) != null && tokenProvider.validateToken(token)){
            return ResponseEntity.ok(new JwtAuthenticationResponse(token));
        }
        return ResponseEntity.badRequest().body(new ErrorResponse(Arrays.asList("Token not found or not valid")));
    }

    /**
     * Get user from security context and generate token
     * @param body access token
     * @return JwtAuthenticationResponse with token
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/revoke-token")
    public ResponseEntity<?> getToken(@RequestBody RevokeTokenRequest body) throws UnsupportedEncodingException {
        if(StringUtils.isEmpty(body.getAccessToken())){
            return ResponseEntity.badRequest().body(new ErrorResponse(Arrays.asList("No access-token found")));
        }
        tokenService.revokeToken(body.getAccessToken());
        return ResponseEntity.ok(new OKResponse("Token revoked with success."));
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

}
