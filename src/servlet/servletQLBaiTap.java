package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.BaitapDAO;
import dao.ChudeDAO;
import model.Baitap;
import model.Chude;

@WebServlet("/servletQLBaiTap")
public class servletQLBaiTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final BaitapDAO dao = new BaitapDAO();
	private static final ChudeDAO daoCD = new ChudeDAO();

	public servletQLBaiTap() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Baitap baitap;
		String id;
		String action = request.getParameter("action");
		String idcd = request.getParameter("cd");
		List<Chude> listchude = daoCD.findALL();
		request.setAttribute("listchude", listchude);
		List<Baitap> listBTtheoCD = new ArrayList<Baitap>();
		List<Baitap> listbaitap = dao.findALL();
		if (action == null || action.equals("")) {
			if (idcd != null) {
				for (Baitap bt : listbaitap) {
					if (bt.getChude().getMaCd().equals(idcd)) {
						listBTtheoCD.add(bt);
					}
				}
			} else {
				listBTtheoCD = listbaitap;
			}
			request.setAttribute("listbaitap", listBTtheoCD);
			request.getRequestDispatcher("/WEB-INF/admin/danhsachbaitap.jsp").forward(request, response);
			return;
		}

		switch (action) {
		case "add":
			id = request.getParameter("id");
			baitap = dao.findByid(id);
			if (baitap == null) {
				request.setAttribute("baitap", new Baitap("", new Chude(), "", "", "", 10));
			}
			request.setAttribute("baitap", baitap);
			request.setAttribute("ACTION", "save");
			request.getRequestDispatcher("/WEB-INF/admin/chitietbaitap.jsp").forward(request, response);
			break;
		case "save":
			try {
				HashMap<String, String> fields = new HashMap<String, String>();

				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);

				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request); // Now using an instance of ServletFileUpload

				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					if (item.isFormField()) {
						fields.put(item.getFieldName(), item.getString());
						String name = item.getFieldName();
						String value = item.getString();
						System.out.println("name: " + name);
						System.out.println("value: " + value);
					}
				}

				id = fields.get("id");
				System.out.println("id can tim : " + id);
				baitap = dao.findByid(id);
				if (baitap == null) {
					System.out.println("f//====No Select====");
					Baitap baitapmoi = new Baitap();
					baitapmoi.setMaBt(fields.get("id"));
					baitapmoi.setCauHoi(fields.get("name"));
					baitapmoi.setGoiY(fields.get("suggest"));
					baitapmoi.setDapAn(fields.get("answer"));
					baitapmoi.setDiemSo(Integer.parseInt(fields.get("number")));
					Chude chudenew = new Chude();
					chudenew.setMaCd(fields.get("option"));
					baitapmoi.setChude(chudenew);
					dao.add(baitapmoi);
					System.out.println("f//====Save====");
				} else {
					System.out.println("f//====Select====");
					Baitap baitapmoi = new Baitap();
					baitapmoi.setMaBt(fields.get("id"));
					baitapmoi.setCauHoi(fields.get("name"));
					baitapmoi.setGoiY(fields.get("suggest"));
					baitapmoi.setDapAn(fields.get("answer"));
					baitapmoi.setDiemSo(Integer.parseInt(fields.get("number")));
					Chude chudenew = new Chude();
					chudenew.setMaCd(fields.get("option"));
					baitapmoi.setChude(chudenew);
					dao.update(baitapmoi);
					System.out.println("f//====Upload====");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("listbaitap", dao.findALL());
			request.getRequestDispatcher("/WEB-INF/admin/danhsachbaitap.jsp").forward(request, response);
			break;
		case "delete":
			String iddel = request.getParameter("id");
			dao.delete(iddel);
			request.setAttribute("listbaitap", dao.findALL());
			request.getRequestDispatcher("/WEB-INF/admin/danhsachbaitap.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
