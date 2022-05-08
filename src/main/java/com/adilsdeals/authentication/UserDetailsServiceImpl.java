package com.adilsdeals.authentication;

import com.adilsdeals.employee.Employee;
import com.adilsdeals.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Employee with username %s not found", username)));
        return new User(employee.getUsername(), employee.getPassword(), getAuthorities());
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(){
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }
}
