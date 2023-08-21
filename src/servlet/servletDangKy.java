package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.TaikhoanDAO;
import model.Taikhoan;
import uti.HibernateUti;

/**
 * Servlet implementation class servletDangKy
 */
@WebServlet("/servletDangKy")
public class servletDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TaikhoanDAO dao = new TaikhoanDAO();

	public servletDangKy() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String TenDangNhap = request.getParameter("TenDangNhap");
		String MatKhau = request.getParameter("MatKhau");
		String MatKhauNhapLai = request.getParameter("NhapLaiMatKhau");
		String HoTen = request.getParameter("HoTen");
		String NamSinh = request.getParameter("NamSinh");
		String GioiTinh = request.getParameter("GioiTinh");
		String QueQuan = request.getParameter("QueQuan");
		String Email = request.getParameter("Email");
		String DongYNhanEmail = request.getParameter("DongYNhanEmail");
		request.setAttribute("TenDangNhap", TenDangNhap);
		request.setAttribute("HoTen", HoTen);
		request.setAttribute("NamSinh", NamSinh);
		request.setAttribute("GioiTinh", GioiTinh);
		request.setAttribute("QueQuan", QueQuan);
		request.setAttribute("Email", Email);
		request.setAttribute("DongYNhanEmail", DongYNhanEmail);
		String url = "";
		String baoloi = "";
		if (existsByName(TenDangNhap)) {
			baoloi += "Tên đăng nhập đã tồn tại ! <br/>";
		}
		if (MatKhau.equals(MatKhauNhapLai) !=true) {
			baoloi += "Mật khẩu và mật khẩu nhập lại không khớp. <br/>";
		}
		if (baoloi.length() > 0) {
			url = "/WEB-INF/view/dangky.jsp";
		} else {
			Random rd = new Random();
			int maKH = rd.nextInt(10000000);
			String id = "TK" + String.valueOf(maKH) + "";
			Taikhoan tk = new Taikhoan(id, TenDangNhap, MatKhau, false, HoTen, stringToDate(NamSinh), GioiTinh, QueQuan,Email);
			dao.add(tk);
			url = "/WEB-INF/view/thanhcong.jsp";
		}
		request.setAttribute("baoloi", baoloi);
		request.getRequestDispatcher(url).forward(request, response);
	}

	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		boolean ketqua = false;
		List<Taikhoan> dstk = dao.findALL();
		for (Taikhoan t : dstk)
		{
			if (t.getTenTk().equals(name))
			{
				ketqua = true;
			}
		}
		return ketqua;
	}

	public Date stringToDate(String dateString) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
