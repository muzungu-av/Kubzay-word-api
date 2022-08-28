package ru.kubzay.restgatewayapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import ru.kubzay.restgatewayapi.security.JwtCsrfFilter;
import ru.kubzay.restgatewayapi.security.JwtTokenRepository;
import ru.kubzay.restgatewayapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${paths.api}")
    String api;

    @Value("${paths.auth}")
    String auth;

    @Value("${paths.login}")
    String login;

    private UserService service;

    private JwtTokenRepository jwtTokenRepository;

    /* нестандартное поведение Idea так что пока отдельно инжектится, для тестов может потребоваться пенести в конструктор
     * а без него вываливается весь стейтрейс в ответе */
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    //<- подавление сообщения "cannot resolve bean..."
    @Resource(name = "handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Autowired
    public SpringSecurityConfig(UserService service, JwtTokenRepository jwtTokenRepository) {
        this.service = service;
        this.jwtTokenRepository = jwtTokenRepository;
    }

    @Bean
    public PasswordEncoder devPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .addFilterAt(new JwtCsrfFilter(jwtTokenRepository, resolver), CsrfFilter.class)
                .csrf().ignoringAntMatchers("/**")
                .and()
                .authorizeRequests()
                // раскоментировать для включения полноценной (не по токену) авторизации, однако токен по-прежнему будет необходим
//                .antMatchers( "/private/**").fullyAuthenticated()
                .antMatchers(api + auth + login).authenticated()
                .and()
                .httpBasic()
                .authenticationEntryPoint(((request, response, e) -> resolver.resolveException(request, response, null, e)));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.service);
    }

    /**
     * Публичные ресурсы должны быть доступны, JwtCsrfFilter не будет блокировать их.
     * Для этого такие ресурсы нужно добавить WebSecurity.ignoring()
     * <p>
     * Сюда добавляем корневой ресурс где находиться корневая страница.
     * <p>
     * смотри https://github.com/spring-projects/spring-security/issues/4368
     * < KevinWingi commented on 8 Jun 2019) >
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(HttpMethod.GET, "/")
                .antMatchers(HttpMethod.GET, "/index.html")
                .antMatchers(HttpMethod.GET, "/public/**")
                .antMatchers(HttpMethod.GET, "/static/**");
    }
}
