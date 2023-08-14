package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BaitapDAO;
import dao.ChudeDAO;
import dao.TaikhoanthuchienchudeDAO;
import dao.TuvungDAO;
import model.Baitap;
import model.Chude;
import model.Taikhoan;
import model.Taikhoanthuchienchude;
import model.TaikhoanthuchienchudeId;
import model.Tuvung;

/**
 * Servlet implementation class servletHienThi
 */
@WebServlet("/servletHienThi")
public class servletHienThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ChudeDAO dao = new ChudeDAO();
	private static final TuvungDAO daoTV = new TuvungDAO();
	private static final BaitapDAO daoBT = new BaitapDAO();
	private static final TaikhoanthuchienchudeDAO daoTHBT = new TaikhoanthuchienchudeDAO();

	public servletHienThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String url = "";
		if (action == null)
			action = "hienthi";
		switch (action) {
		case "hienthi":
			List<Chude> listchude = dao.findALL();
			request.setAttribute("listchude", listchude);
			url = "/WEB-INF/view/trangchu.jsp";
			break;
		case "dangky":
			url = "/WEB-INF/view/dangky.jsp";
			break;
		case "dangnhap":
			url = "/WEB-INF/view/dangnhap.jsp";
			break;
		case "dangxuat":
			session.invalidate();
			url = "/index.jsp";
			break;
		case "tuvung":
			List<Tuvung> listfullTuVung = daoTV.findALL();
			List<Tuvung> listtuvung = new ArrayList<Tuvung>();
			int id = Integer.parseInt(request.getParameter("id"));
			session.setAttribute("idchude", id);
			for (Tuvung tv : listfullTuVung) {
				if (tv.getChude().getMaCd() == id) {
					listtuvung.add(tv);
				}
			}
			request.setAttribute("listtuvung", listtuvung);
			url = "/WEB-INF/view/tuvung.jsp";
			break;
		case "baitap":
			int idchude = (int) session.getAttribute("idchude");
			List<Baitap> listBT = daoBT.findALL();
			List<Baitap> listBaiTapCD = new ArrayList<Baitap>();
			for (Baitap bt : listBT) {
				if (bt.getChude().getMaCd() == idchude) {
					listBaiTapCD.add(bt);
				}
			}
			session.setAttribute("listBaiTapCD", listBaiTapCD);
			url = "/WEB-INF/view/baitap.jsp";
			break;
		case "baitapchude":
			int Tongdiem = (int) session.getAttribute("totalScore");
			int idbaitapchude = (int) session.getAttribute("idchude");
			Taikhoan taikhoan = (Taikhoan) session.getAttribute("Taikhoan");
			Chude chude = new Chude();
			chude.setMaCd(idbaitapchude);
			TaikhoanthuchienchudeId idchudebt = new TaikhoanthuchienchudeId(taikhoan.getMaTk(), idbaitapchude); 
			Taikhoanthuchienchude taikhoanthuchienchude = new Taikhoanthuchienchude(idchudebt,chude,taikhoan,new Date(),true,Tongdiem);	 
			daoTHBT.add(taikhoanthuchienchude);
			
			url = "/servletXepHang";
			break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
