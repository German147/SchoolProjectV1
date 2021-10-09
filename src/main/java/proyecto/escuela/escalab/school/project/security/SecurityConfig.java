package proyecto.escuela.escalab.school.project.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/alumnos").hasAnyAuthority("ROLE_PROFESOR")
                .antMatchers(HttpMethod.GET, "/api/v1/apoderados").hasAnyAuthority("ROLE_PRECEPTOR")
                .antMatchers(HttpMethod.GET, "/api/v1/asignaturas").hasAnyAuthority("ROLE_ALUMNO", "ROLE_PROFESOR", "SECRETARIA")
                .antMatchers(HttpMethod.GET, "/api/v1/contenidos").hasAnyAuthority("ROLE_ALUMNO", "ROLE_PROFESOR")
                .antMatchers(HttpMethod.GET, "/api/v1/cursos").hasAnyAuthority("ROLE_PRECEPTOR", "ROLE_PROFESOR")
                .antMatchers(HttpMethod.GET, "/api/v1/ficha_medica").hasAnyAuthority("ROLE_PRECEPTOR", "ROLE_SECRETARIA")
                .antMatchers(HttpMethod.GET, "/api/v1/profesores").hasAnyAuthority("ROLE_PRECEPTOR", "ROLE_SECRETARIA", "ROLE_ALUMNO", "ROLE_DIRECTOR")
                .antMatchers(HttpMethod.GET, "/api/v1/registro_academico").hasAnyAuthority("ROLE_PRECEPTOR", "ROLE_SECRETARIA", "ROLE_DIRECTOR")
                .antMatchers(HttpMethod.GET, "/api/v1/toma_asignaturas").hasAnyAuthority("ROLE_SECRETARIA", "ROLE_DIRECTOR", "ROLE_PROFESOR")
                .anyRequest()
                .authenticated();

        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
