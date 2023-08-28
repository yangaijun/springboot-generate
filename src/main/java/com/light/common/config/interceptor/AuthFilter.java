package com.light.common.config.interceptor;

import com.light.common.exception.BusinessException;
import com.light.common.exception.BusinessExceptionErrorEnum;
import com.light.common.threadlocal.ThreadlocalContext;
import com.light.common.threadlocal.ThreadlocalManager;
import com.light.common.utils.TokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthFilter extends OncePerRequestFilter {
    @Value("${auth.open}")
    private Boolean open;
    @Value("${auth.tokenName}")
    private String tokenName;

    @Value("${auth.passPaths}")
    private String passPaths;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (open && !request.getMethod().equals("OPTIONS")) {
            String urlPath = request.getServletPath();
            String[] paths = passPaths.split(",");
            PathMatcher matcher = new AntPathMatcher();

            for (int i = 0; i < paths.length; i++) {
                if(matcher.match(paths[i].trim(), urlPath)){
                    chain.doFilter(request, response);
                    return;
                }
            }

            String authToken = request.getHeader(tokenName);
            Integer userId = TokenUtil.getUserId(authToken);

            System.out.println(authToken);

            if (!TokenUtil.isValid(authToken)) {
                throw new BusinessException(BusinessExceptionErrorEnum.TOKEN_EXPIRED);
            }

            if (userId == null) {
                throw new BusinessException(BusinessExceptionErrorEnum.TOKEN_PARSE_ERROR);
            }

            ThreadlocalContext threadlocalContext = new ThreadlocalContext();
            threadlocalContext.setUserId(userId);

            ThreadlocalManager.setThreadContext(threadlocalContext);
        }

        chain.doFilter(request, response);
    }
}