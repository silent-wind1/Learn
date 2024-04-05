package com.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
//     首页所有人可以访问，功能页只对应有权限的人访问
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
//        没有权限默认会登录页面，需要开启登录页面的页面
        http.formLogin();
//      注销，开启注销功能,然后回到首页
        http.logout().logoutSuccessUrl("/");
//      开启记住我功能,cookie,默认有效期2周
        http.rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("yefeng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3").and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3").and()
                .withUser("guet").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3").roles();
    }
}
