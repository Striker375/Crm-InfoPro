package crm.crm.controller;

import crm.crm.repository.MemberRepository;
import lombok.AllArgsConstructor;
import crm.crm.entity.Employee;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController @AllArgsConstructor @RequestMapping("/api/user")
public class MemberRestController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Employee register(@RequestBody Employee user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return memberRepository.save(user);
    }
}