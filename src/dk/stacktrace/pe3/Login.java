package dk.stacktrace.pe3;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfo userInfo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        userInfo = new UserInfo();
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember_username");
						
		 if (userInfo.userExists(username, password))
		{
			 System.out.println("User exists!!");
			if(remember != null)
			{
				Cookie userCookie = new Cookie("username", username);
				userCookie.setMaxAge(100);
				response.addCookie(userCookie);
				System.out.print("Cookie has been set");
			}
			
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("cart", new ShoppingCart());
			
			response.sendRedirect(response.encodeRedirectURL("private/main.jsp"));
		} 
		 else
		{
			 response.sendRedirect(response.encodeRedirectURL("login.jsp"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
