package main.java.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyServlet", urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream out = resp.getOutputStream();

		String res = "<html>\n" + "<head>\n" + "<title>dude</title>\n" + "</head>\n" + "<body>\n"
				+ "	<h2>hell yea</h2>" + "<center>\n";

		for (int i = 0; i < 800; i++) {
			for (int j = 0; j < i % (100 + j); j++) {
				if (Math.random() > 0.5)
					res += " x ";
				else
					res += " - ";
			}
			res += "<br>\n";
		}
		res += "</center>" + "</body>\n" + "</html>";
		out.write(res.getBytes());
		out.flush();
		out.close();
	}

}
