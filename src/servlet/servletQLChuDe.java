package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ChudeDAO;
import model.Chude;

/**
 * Servlet implementation class servletQLChuDe
 */
@WebServlet("/servletQLChuDe")
/*
 * @MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB maxFileSize =
 * 1024 * 1024 * 10, // 10MB maxRequestSize = 1024 * 1024 * 50)
 */ // 50MB
public class servletQLChuDe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ChudeDAO dao = new ChudeDAO();

	public servletQLChuDe() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		Chude chude;
		String id;
		String filename = null;
		String action = request.getParameter("action");
		if (action == null || action.equals("")) {
			List<Chude> listchude = dao.findALL();
			request.setAttribute("listchude", listchude);
			request.getRequestDispatcher("/WEB-INF/admin/danhsachchude.jsp").forward(request, response);
			return;
		}
		switch (action) {
		case "add":
				id = request.getParameter("id");	
				chude = dao.findByid(id);
				if (chude == null) {
					request.setAttribute("chude", new Chude("", "", ""));
				}
				request.setAttribute("chude", chude);
				request.setAttribute("ACTION", "save");
			request.getRequestDispatcher("/WEB-INF/admin/chitietchude.jsp").forward(request, response);
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
				chude = dao.findByid(id);
				if (chude == null) {
					System.out.println("f//====No Select====");
					Chude chudemoi = new Chude();
					chudemoi.setMaCd(fields.get("id"));
					chudemoi.setTenCd(fields.get("name"));
					chudemoi.setHinhAnhCd(filename);
					dao.add(chudemoi);
					System.out.println("f//====Save====");
				} else {
					System.out.println("f//====Select====");
					Chude chudemoi = new Chude();
					chudemoi.setMaCd(fields.get("id"));
					chudemoi.setTenCd(fields.get("name"));
					if (filename == null || filename.equals("")) {
						System.out.println("f//====No Img====");
						chudemoi.setHinhAnhCd(chude.getHinhAnhCd());
					} else {
						chudemoi.setHinhAnhCd(filename);
					}
					dao.update(chudemoi);
					System.out.println("f//====Upload====");

				}
				List<Chude> listchude = dao.findALL();
				request.setAttribute("listchude", listchude);
				request.getRequestDispatcher("/WEB-INF/admin/danhsachchude.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			request.getRequestDispatcher("/WEB-INF/admin/danhsachchude.jsp").forward(request, response);
			break;
		case "delete":
			String iddel = request.getParameter("id");
			dao.delete(iddel);
			List<Chude> listchude = dao.findALL();
			request.setAttribute("listchude", listchude);
			request.getRequestDispatcher("/WEB-INF/admin/danhsachchude.jsp").forward(request, response);
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
