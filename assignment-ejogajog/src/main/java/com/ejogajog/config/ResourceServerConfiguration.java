package com.ejogajog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.ejogajog.constants.ScopeTypes;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
    private DefaultTokenServices tokenServices;
    
    private static final String RESOURCE_ID = null;
    private static final String SECURED_PATTERN = "/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).tokenServices(tokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers(SECURED_PATTERN).and().authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(ScopeTypes.WRITE)
                .antMatchers(HttpMethod.PUT, SECURED_PATTERN).access(ScopeTypes.WRITE)
                .antMatchers(HttpMethod.DELETE, SECURED_PATTERN).access(ScopeTypes.DELETE)
                .anyRequest().access(ScopeTypes.READ);
    }
    
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }

    @Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

    @Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		CustomJwtAccessTokenConverter converter = new CustomJwtAccessTokenConverter();
		converter.setSigningKey("123");
		return converter;
	}
   
}