package jcafe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetProductListServlet
 */
@WebServlet("/GetProductListServlet")
public class GetProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetProductListServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=UTP-8");
	 ProductDAO dao = new ProductDAO();
		List<ProductVO> list = dao.getProductList();
		// [{"item_no":"bean_001, "item":"콜롬비아원두"},{},{},{}]
		int lastData = list.size();
		int i=0;
		String json = "[";
		for (ProductVO vo : list) {
			i++;
			json += "{\"item_no\":\"" + vo.getItemNo() + "\""// 
					+ ",\"item\":\"" + vo.getItem() +"\""// 
					+ ",\"category\":\"" + vo.getCategory() +"\""//
					+ ",\"price\":\"" + vo.getPrice() +"\""//
					+ ",\"link\":\"" + vo.getLink() +"\""//
					+ ",\"content\":\"" + vo.getContent() +"\""//
					+ ",\"like_It\":\"" + vo.getLikeIt() +"\""//
					+ ",\"alt\":\"" + vo.getAlt() +"\""//
					+ ",\"image\":\"" + vo.getImage() +"\""//
					+ "}";
			if(i !=lastData) {
				json+=",";
			}
		}
		json += "]";
		response.getWriter().append(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
