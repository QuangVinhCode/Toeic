package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaikhoanDAO;
import model.Taikhoan;

/**
 * Servlet implementation class servletDangNhap
 */
@WebServlet("/servletDangNhap")
public class servletDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TaikhoanDAO dao = new TaikhoanDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletDangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
		String TenDangNhap = request.getParameter("TenDangNhap");
		String MatKhau = request.getParameter("MatKhau");
		String url = "";
		Taikhoan tk = new Taikhoan();
		tk.setTenTk(TenDangNhap);
		tk.setMatKhauTk(MatKhau);
		//Taikhoan Taikhoan = dao.findTaiKhoanByTenAndMatKhau(tk.getTenTk().toString(), tk.getMatKhauTk().toString());
		Taikhoan Taikhoan = TimTKvaMK(TenDangNhap, MatKhau	);
		if (Taikhoan != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("Taikhoan", Taikhoan);
			url = "/servletHienThi?action=hienthi";
		}
		else {
			request.setAttribute("baoloi", "Tên đăng nhập hoặc mật khẩu không chính xác");
			url = "/WEB-INF/view/dangnhap.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	public Taikhoan TimTKvaMK(String TenDangNhap,String MatKhau)
	{
		List<Taikhoan> listTK = dao.findALL();
		for (Taikhoan tk : listTK)
		{
			if (tk.getTenTk().equals(TenDangNhap) && tk.getMatKhauTk().equals(MatKhau))
			{
				System.out.print(tk.getTenTk() + " " + tk.getMatKhauTk());
				return tk;
			}
		}
		return null;
	}

}
