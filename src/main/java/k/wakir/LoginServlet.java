package k.wakir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login1")
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Users users = userDao.getUsers(email, password);
		if (users.getFirstName() == null) {
			req.setAttribute("Error", "No users were found");
			req.getRequestDispatcher("SignUp.jsp").forward(req, res);
		}else {
			req.setAttribute("welcome",users.getFirstName()+" "+users.getLastName());
			req.getRequestDispatcher("Welcome.jsp").forward(req, res);
		}
	}
}
