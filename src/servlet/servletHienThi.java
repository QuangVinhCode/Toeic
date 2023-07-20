package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChudeDAO;
import model.Chude;

/**
 * Servlet implementation class servletHienThi
 */
@WebServlet("/servletHienThi")
public class servletHienThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final ChudeDAO dao = new ChudeDAO();
	
    public servletHienThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Chude> listchude = dao.findALL();
		request.setAttribute("listchude", listchude);
		request.getRequestDispatcher("/WEB-INF/view/trangchu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
