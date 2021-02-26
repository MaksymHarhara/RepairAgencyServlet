package ua.training.controller.filters;

import ua.training.model.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.training.controller.util.Constants.INDEX_PAGE;

public class AccessFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        //TODO refactor
        if (path.contains("master")) {
            if (request.getSession().getAttribute("role").equals(Role.MASTER)) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //TODO refactor
                request.setAttribute("error", true);
                request.setAttribute("message", "AccessDenied");
                request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
            }
        }else
            if (path.contains("manager")) {
            if (request.getSession().getAttribute("role").equals(Role.MANAGER)){
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                //TODO refactor
                request.setAttribute("error", true);
                request.setAttribute("message", "AccessDenied");
                request.getRequestDispatcher(INDEX_PAGE).forward(request, response);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
