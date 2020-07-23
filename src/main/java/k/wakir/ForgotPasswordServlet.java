package k.wakir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		
		String email = req.getParameter("email");
		String countryCode = req.getParameter("countryCode");
		String mobileNumber = req.getParameter("phoneNumber");
		String finalNumber = countryCode+" "+mobileNumber;
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		Users users = userDao.getForgotPasswordUser(email, finalNumber);
		if (users.getFirstName() == null) {
			req.setAttribute("Error", "There is no users according to the particular email and mobile number");
			req.getRequestDispatcher("forgotPassword.jsp").forward(req, res);
		}else {
			if (!password.equals(confirmPassword)) {
				req.setAttribute("Error", "Password is not matching");
				req.getRequestDispatcher("forgotPassword.jsp").forward(req, res);
			}else {
				userDao.updateUsers(email, finalNumber, confirmPassword);
				res.sendRedirect("index.jsp");
			}
		}
	}
}
