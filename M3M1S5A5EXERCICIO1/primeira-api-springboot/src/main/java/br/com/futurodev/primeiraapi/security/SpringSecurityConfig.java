package br.com.futurodev.primeiraapi.security;

import br.com.futurodev.primeiraapi.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* Ativa a proteção contra usuários que não estão validados por TOKEN  */
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

                /* Ativamos a permissão para acesso a página inicial do sistema EX: http://fugurodev.com */
                .disable().authorizeRequests().antMatchers("/").permitAll()

                /* URL de Logout * Redireciona o usuário após deslogar do sistema*/
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/index")

                /* Mapeia URL de logout e invalida o usuário */
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

                /* Filtrar as requisições de login  para fazer a autenticação */

        /* Filtrar demais requisições para verificar a preservação do TOKEN JWT no HEADER do HTTP */

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* Service que irá consultar o usuário no bando de dados */
        auth.userDetailsService(cadastroUsuarioService)

                /* Definidos o padrão de codificação de senha */
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}

