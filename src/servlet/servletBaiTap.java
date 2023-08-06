package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BaitapDAO;
import model.Baitap;

/**
 * Servlet implementation class servletBaiTap
 */
@WebServlet("/servletBaiTap")
public class servletBaiTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public servletBaiTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		List<Baitap> questions = new BaitapDAO().findALL();
		int totalCorrectAnswers = 0;
		int totalScore = 0;

		try {
			for (Baitap question : questions) {
				String userAnswer = request.getParameter("answer_" + question.getMaBt());
				String correctAnswer = question.getDapAn();

				if (userAnswer != null && userAnswer.trim().equalsIgnoreCase(correctAnswer)) {
					totalCorrectAnswers++;
					totalScore += question.getDiemSo();
				}
			}

			// Store the quiz result in a map
			Map<String, Object> quizResult = new HashMap<>();
			quizResult.put("totalCorrectAnswers", totalCorrectAnswers);
			quizResult.put("totalScore", totalScore);

			// Set the quiz result as a request attribute to pass to the result.jsp
			request.setAttribute("quizResult", quizResult);

			// Forward to result.jsp for displaying the result
			request.getRequestDispatcher("/WEB-INF/view/ketquabaitap.jsp").forward(request, response);

		} catch (Exception e) {
			// Handle any exceptions if needed
			e.printStackTrace();
		}

	}

}
