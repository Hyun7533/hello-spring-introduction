package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class SpringConfig {

    private MemberRepository memberRepository;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SpringConfig(MemberRepository memberRepository, JdbcTemplate jdbcTemplate) {
        this.memberRepository = memberRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository);
//    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository((DataSource) jdbcTemplate);
    }

}
