package k.wakir;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/register1")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImpl();
		
		
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");
		String company = req.getParameter("company");
		String countryCode = req.getParameter("countryCode");
		String phoneNumber = req.getParameter("phoneNumber");
		String finalNumber = countryCode+" "+phoneNumber;
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		String iAccept = req.getParameter("IAccept");
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
		
		Pattern pat = Pattern.compile(emailRegex);
		boolean isValidEmail = pat.matcher(email).matches();
		if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
				company.isEmpty() ||phoneNumber.isEmpty() || password.isEmpty() ||
				confirmPassword.isEmpty()) {
			req.setAttribute("Error", "Fields should not be empty");
			req.getRequestDispatcher("SignUp.jsp").forward(req, res);
		}else {
			if (iAccept == null) {
				req.setAttribute("Error", "You must accept our privacy policy");
				req.getRequestDispatcher("SignUp.jsp").forward(req, res);
			}else {
				if (isValidEmail) {
					if (!password.equals(confirmPassword)) {
						req.setAttribute("Error", "Password is not matching");
						req.getRequestDispatcher("SignUp.jsp").forward(req, res);
					}else {
						Users users = new Users(firstName, lastName, email, company, finalNumber, password);
						userDao.insertUser(users);
						res.sendRedirect("index.jsp");
					}
					}else {
					req.setAttribute("Error", "Email is badly formatted");
					req.getRequestDispatcher("SignUp.jsp").forward(req, res);
				}
			}
		}
		
	}
}
