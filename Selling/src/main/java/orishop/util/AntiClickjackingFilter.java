package orishop.util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AntiClickjackingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AntiClickjackingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("X-Frame-Options", "DENY");
        httpResponse.setHeader("X-Content-Type-Options", "nosniff");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("AntiClickjackingFilter destroyed");
    }
}