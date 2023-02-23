package com.example.demo.filters;

import com.example.demo.connection.ConnectionUtils;
import com.example.demo.models.UserAccount;
import com.example.demo.service.UserAccountServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"})
public class CookieFilter implements Filter {
	
	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
        ConnectionUtils connectionUtil = new ConnectionUtils();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserAccount userAccount = connectionUtil.getLoginUser(session);
        if(userAccount != null){
            session.setAttribute("cookieChecked", "checked" );
            chain.doFilter(request, response);
        }
        try {
            Connection conn = connectionUtil.getConnection();
            String checked = (String) session.getAttribute("cookieChecked");
            if(checked == null && conn != null) {
                String userName = connectionUtil.getUserNameFromCookie(req);
                UserAccount user = new UserAccountServiceImpl().findUser(userName);
                if(user != null) connectionUtil.storeLoginUser(session, user);
                session.setAttribute("cookieChecked", "checked" );
    
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        chain.doFilter(request, response);
	}
}
