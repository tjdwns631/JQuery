package jcafe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProductSevlet")
public class DeleteProductSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteProductSevlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String itemNo = request.getParameter("itemNo");//파라메터 이름
		ProductDAO dao = new ProductDAO();
		dao.deleteProduct(itemNo);
		
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
