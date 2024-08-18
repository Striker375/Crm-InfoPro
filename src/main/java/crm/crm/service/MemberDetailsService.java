package crm.crm.service;

import crm.crm.repository.MemberRepository;
import crm.crm.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @AllArgsConstructor
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> user = memberRepository.findByUsername(username);
        if (user.isPresent()) {
            var member = user.get();
            return new org.springframework.security.core.userdetails.User(
                    member.getUsername(),
                    member.getPassword(),
                    member.getAuthorities()
            );
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}