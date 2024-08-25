package com.example.zhou.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CORSFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        response1.addHeader("Access-Control-Allow-Credentials", "true");
        response1.addHeader("Access-Control-Allow-Origin", "*");
        response1.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        response1.addHeader("Access-Control-Allow-Headers",
                "range,Accept-Ranges,Content-Range,Content-Type," +
                "X-CAF-Authorization-Token,sessionToken,X-TOKEN,Cache-Control,If-Modified-Since");
        if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
            response.getWriter().println("ok");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
