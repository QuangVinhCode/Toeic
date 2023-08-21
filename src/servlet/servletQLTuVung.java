package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ChudeDAO;
import dao.TuvungDAO;
import model.Chude;
import model.Tuvung;

@WebServlet("/servletQLTuVung")
public class servletQLTuVung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final TuvungDAO dao = new TuvungDAO();
	private static final ChudeDAO daoCD = new ChudeDAO();

	public servletQLTuVung() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Tuvung Tuvung;
		String id;
		String filename = null;
		String action = request.getParameter("action");
		String idcd = request.getParameter("cd");
		List<Tuvung> listTVtheoCD = new ArrayList<Tuvung>();
		List<Chude> listchude = daoCD.findALL();
		request.setAttribute("listchude", listchude);
		if (action == null || action.equals("")) {
			List<Tuvung> listTuvung = dao.findALL();
			if (idcd != null) {
				for (Tuvung tv : listTuvung) {
					if (tv.getChude().getMaCd().equals(idcd)) {
						listTVtheoCD.add(tv);
					}
				}
			} else {
				listTVtheoCD = listTuvung;
			}
			request.setAttribute("listTVtheoCD", listTVtheoCD);
			request.getRequestDispatcher("/WEB-INF/admin/danhsachtuvung.jsp").forward(request, response);
			return;
		}
		switch (action) {
		case "add":
			id = request.getParameter("id");
			Tuvung = dao.findByid(id);
			if (Tuvung == null) {
				Random rd = new Random();
				int idCD = rd.nextInt(1000000);
				Chude newcd = new Chude();
				request.setAttribute("tuvung", new Tuvung("", newcd, "", "", ""));
			}
			request.setAttribute("tuvung", Tuvung);
			request.setAttribute("ACTION", "save");
			request.getRequestDispatcher("/WEB-INF/admin/chitiettuvung.jsp").forward(request, response);
			break;
		case "save":
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();

				ServletContext servletContext = this.getServletConfig().getServletContext();
				File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
				factory.setRepository(repository);

				ServletFileUpload upload = new ServletFileUpload(factory);

				List<FileItem> items = upload.parseRequest(request);

				Iterator<FileItem> iter = items.iterator();
				HashMap<String, String> fields = new HashMap<String, String>();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					if (item.isFormField()) {
						fields.put(item.getFieldName(), item.getString());
						String name = item.getFieldName();
						String value = item.getString();
						System.out.println("name: " + name);
						System.out.println("value: " + value);
					} else {
						filename = item.getName();
						System.out.println("filename: " + filename);
						if (filename == null || filename.equals("")) {
							break;
						} else {
							Path path = Paths.get(filename);
							String storePath = servletContext.getRealPath("/images");

							File uploadFile = new File(storePath + "/" + path.getFileName());
							item.write(uploadFile);
							System.out.println(storePath + "/" + path.getFileName());
						}
					}
				}
				id = fields.get("id");
				System.out.println("id " + id);
				Tuvung = dao.findByid(id);
				if (Tuvung == null) {
					System.out.println("f//====No Select====");
					Tuvung Tuvungmoi = new Tuvung();
					Tuvungmoi.setMaTv(fields.get("id"));
					Tuvungmoi.setTenTuVung(fields.get("name"));
					Tuvungmoi.setHinhAnhTv(filename);
					Chude newcd = new Chude();
					newcd.setMaCd(fields.get("option"));
					Tuvungmoi.setChude(newcd);
					Tuvungmoi.setDichTv(fields.get("translate"));
					dao.add(Tuvungmoi);
					System.out.println("f//====Save====");
				} else {
					System.out.println("f//====Select====");
					Tuvung Tuvungmoi = new Tuvung();
					Tuvungmoi.setMaTv(fields.get("id"));
					Tuvungmoi.setTenTuVung(fields.get("name"));
					Chude newcd = new Chude();
					newcd.setMaCd(fields.get("option"));
					Tuvungmoi.setChude(newcd);
					Tuvungmoi.setDichTv(fields.get("translate"));
					if (filename == null || filename.equals("")) {
						System.out.println("f//====No Img====");
						Tuvungmoi.setHinhAnhTv(Tuvung.getHinhAnhTv());
					} else {
						Tuvungmoi.setHinhAnhTv(filename);
					}
					dao.update(Tuvungmoi);
					System.out.println("f//====Upload====");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("listTVtheoCD", dao.findALL());
			request.getRequestDispatcher("/WEB-INF/admin/danhsachtuvung.jsp").forward(request, response);
			break;
		case "delete":
			String iddel = request.getParameter("id");
			dao.delete(iddel);
			request.setAttribute("listTVtheoCD", dao.findALL());
			request.getRequestDispatcher("/WEB-INF/admin/danhsachtuvung.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
