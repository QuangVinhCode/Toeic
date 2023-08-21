package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaikhoanthuchienchudeDAO;
import model.Taikhoanthuchienchude;

/**
 * Servlet implementation class servletXepHang
 */
@WebServlet("/servletXepHang")
public class servletXepHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TaikhoanthuchienchudeDAO dao = new TaikhoanthuchienchudeDAO();

	public servletXepHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcd = request.getParameter("cd");
		List<Taikhoanthuchienchude> listTK = dao.findALL();
		List<Taikhoanthuchienchude> listTKCD = new ArrayList<Taikhoanthuchienchude>();
		List<Taikhoanthuchienchude> listTKXH = new ArrayList<Taikhoanthuchienchude>();
		String tieude ="";
		if (idcd != null) {
			for (Taikhoanthuchienchude tk : listTK) {
				if (tk.getChude().getMaCd().equals(idcd)) {
					listTKCD.add(tk);
					tieude = tk.getChude().getTenCd();
				}
			}
			listTKXH = SapXepThuTu(listTKCD);
		} else {
			tieude = "Full";
			listTKXH = SapXepThuTu(listTK);
		}
		request.setAttribute("listTKXH", listTKXH);
		request.setAttribute("tieude", tieude);
		request.getRequestDispatcher("/WEB-INF/view/xephang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public List<Taikhoanthuchienchude> SapXepThuTu(List<Taikhoanthuchienchude> listTK) {
		for (int i = 0; i < listTK.size(); i++) {
			for (int j = 0; j < listTK.size() - i - 1; j++) {
				if (listTK.get(i).getTongDiem() < listTK.get(j + 1).getTongDiem()) {
					Taikhoanthuchienchude temp = listTK.get(i);
					listTK.set(i, listTK.get(j + 1));
					listTK.set(j + 1, temp);
				}
			}
		}
		return listTK;
	}
}
