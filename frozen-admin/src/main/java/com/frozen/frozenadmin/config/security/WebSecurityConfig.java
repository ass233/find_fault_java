package com.frozen.frozenadmin.config.security;

import com.frozen.frozenadmin.config.security.authentication.*;
import com.frozen.frozenadmin.config.security.authorize.MyUserDetailsService;
import com.frozen.frozenadmin.config.security.authorize.CustomMetadataSource;
import com.frozen.frozenadmin.config.security.authorize.UrlAccessDecisionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Auther: Frozen
 * @Date: 2019/4/20 19:21
 * @Description:
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    CustomMetadataSource metadataSource;
    @Autowired
    UrlAccessDecisionManager urlAccessDecisionManager;
    @Autowired
    AuthenticationAccessDeniedHandler deniedHandler;
    @Autowired
    CustomInvalidSessionStrategy invalidSessionStrategy;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    /**
     * 配置认证逻辑——用户信息合法性校验（用户名密码校验）
     * @param auth
     * @tMyows Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        //auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web){
        //不需要权限校验的
        web.ignoring().antMatchers("/index", "/static/**", "/hhh");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        o.setSecurityMetadataSource(metadataSource);
                        return o;
                    }
                })
                .anyRequest()
                .authenticated()// 其他 url 需要身份认证
                .and()
                .formLogin()  //开启登录
                .successHandler(new MyAuthenticationSuccessHandler())
                .failureHandler(new MyAuthenticationFailureHandler())
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(deniedHandler);
    }

}
