package orishop.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*") // Áp dụng cho tất cả các servlet
public class GlobalExceptionFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("An error occurred", e);
            if (response instanceof javax.servlet.http.HttpServletResponse) {
                ((javax.servlet.http.HttpServletResponse) response).sendRedirect("/views/user/errorPage.jsp"); // Chuyển hướng đến trang lỗi
            }
        }
    }

    @Override
    public void destroy() {
        
    }
}