package com.realestate.properties.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class User implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String address;
    private String username;
    private String password;
    private List<Role> roles;
    private Collection<? extends GrantedAuthority> authorities;
    private String token;

    public User(Long id, String name, String email, String username, String password, List<Role> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
        if(!CollectionUtils.isEmpty(roles)){
            this.authorities = (Collection<? extends GrantedAuthority>)roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()));
        }
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
        if(!CollectionUtils.isEmpty(roles)){
            this.authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        }
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

}
