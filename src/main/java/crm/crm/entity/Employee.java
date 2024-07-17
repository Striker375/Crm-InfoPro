package crm.crm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import crm.crm.Enum.Role;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
})
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role = Role.EMPLOYEE;

    private String name;

    private String email;


    private String position;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Assuming all accounts are non-expired
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Assuming all accounts are non-locked
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Assuming all credentials are non-expired
    }

    @Override
    public boolean isEnabled() {
        return true; // Assuming all accounts are enabled
    }
}