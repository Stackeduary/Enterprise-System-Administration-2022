package com.adilsdeals.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    @Value("${app.security.header_string}")
    private String headerString;

    @Value("${app.security.token_prefix}")
    private String tokenPrefix;

    @Value("${app.security.secret_key}")
    private String secret;

    @Autowired
    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(headerString);

        if(token == null || !token.startsWith(tokenPrefix)) {
            chain.doFilter(request, response);
            return;
        }

        String user = null;
        try {
            user = Jwts.parser()
                    .setSigningKey(secret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token.replace(tokenPrefix, ""))
                    .getBody()
                    .getSubject();
        } catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid");
            return;
        }

        if(user != null){
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(user, "", null);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User is not valid or Unauthorized");
        }
    }
}
