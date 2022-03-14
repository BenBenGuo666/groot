package groot.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http
                .oauth2Login(oauth2 -> oauth2
                        .clientRegistrationRepository(this.clientRegistrationRepository())
                        .authorizedClientRepository(this.authorizedClientRepository())
                        .authorizedClientService(this.authorizedClientService())
                        .loginPage("/login")
                        .authorizationEndpoint(authorization -> authorization
                                .baseUri(this.authorizationRequestBaseUri())
                                .authorizationRequestRepository(this.authorizationRequestRepository())
                                .authorizationRequestResolver(this.authorizationRequestResolver())
                        )
                        .redirectionEndpoint(redirection -> redirection
                                .baseUri(this.authorizationResponseBaseUri())
                        )
                        .tokenEndpoint(token -> token
                                .accessTokenResponseClient(this.accessTokenResponseClient())
                        )
                        .userInfoEndpoint(userInfo -> userInfo
                                .userAuthoritiesMapper(this.userAuthoritiesMapper())
                                .userService(this.oauth2UserService())
                                .oidcUserService(this.oidcUserService())
                        )
                );*/
    }
}
