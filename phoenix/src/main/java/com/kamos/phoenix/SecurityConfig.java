package com.kamos.phoenix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 特定のリクエストに対してセキュリティ設定を無視する
		web.ignoring().antMatchers("webjars/**", "/css/**", "/images/**");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	// 認可に関する設定
    	// loginFormには全てのユーザーのアクセスを可能とする。
    	// その他のパスには認証なしではアクセスを不可とする。
        http.authorizeRequests()
        .antMatchers("loginForm").permitAll()
        .anyRequest().authenticated();
        // ログインに関する設定
        // フォーム認証を有効にし、認証処理のパス、ログインフォームのパス、認証失敗時の遷移先、
        // 認証成功時の遷移先、ユーザー名、パスワードのパラメータ名を設定する。
        http.formLogin()
        .loginProcessingUrl("/login")
        .loginPage("/loginForm")
        .failureUrl("loginForm?error")
        .defaultSuccessUrl("/home",true)
        .usernameParameter("username").passwordParameter("password")
        .and();
        // ログアウトに関する設定
        http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
        .logoutSuccessUrl("/loginForm");
        
        // その他CSRFなどについても設定が必要になるかも
        // TODO: put CSRF protection back into this endpoint
//        .csrf()
//            .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
//            .disable()
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