package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TuvungDAO;
import model.Tuvung;

/**
 * Servlet implementation class servletHienThiTuVung
 */
@WebServlet("/servletHienThiTuVung")
public class servletHienThiTuVung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TuvungDAO dao = new TuvungDAO();
	private static final TuvungDAO temp = new TuvungDAO();

	public servletHienThiTuVung() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tuvung> listfullTuVung = dao.findALL();
		List<Tuvung> listtuvung = new ArrayList<Tuvung>();
		int id = Integer.parseInt(request.getParameter("id"));
		for (Tuvung tv : listfullTuVung) {
			if (tv.getChude().getMaCd() == id) {
				listtuvung.add(tv);
			}
		}
		request.setAttribute("listtuvung", listtuvung);
		request.getRequestDispatcher("/WEB-INF/view/tuvung.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
