package com.kamos.phoenix;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home", "/css/**", "/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/hello", true)
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Required to use GET method for logout
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(new StandardPasswordEncoder());
//        auth
//        	.inMemoryAuthentication()
//        		.withUser("yano").password("pass").roles("USER");
        // inMemoryではなくDBアクセスで認証したい
        
        auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled from yybingodb.user where username = ?")
        .authoritiesByUsernameQuery("select username, role from yybingodb.user_role where username = ?");

    }
    
    @Configuration
    static class AutenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
    	@Autowired
    	UserDetailsService userDetailsService;
    	
    	@Bean
    	PasswordEncoder passwordEncoder() {
    		// パスワードをハッシュ化するための定義を設定する
    		return new BCryptPasswordEncoder();
    	}
    	
    	@Override
    	public void init(AuthenticationManagerBuilder auth) throws Exception {
    		// 認証に関する設定
    		// ここでは認証ユーザーを取得する設定やパスワード照合の設定をする
    		auth.userDetailsService(userDetailsService)
    		.passwordEncoder(passwordEncoder());
    	}
    }
}