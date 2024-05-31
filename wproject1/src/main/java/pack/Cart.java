package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name= request.getParameter("name"); //상품들어와 네임 프라이스받음
		int price= Integer.parseInt(request.getParameter("price"));
		
		HttpSession session = request.getSession(true); //세션 유무체크>만들기
		// ** 중요!!
		ArrayList<Goods> glist= (ArrayList<Goods>)session.getAttribute("list");//오브젝이라 어레이리스트로 캐스팅해줘서넣어줘야한다
		// 리스트란이름의 세션을 꺼내 지리스트에 줌. 객체를캐스팅한애가지리스트
		if(glist== null) glist= new ArrayList<Goods>(); //최초의상품일경우 Goods객체를 담을 glist 만들기 //김밥통만들기
		glist.add(new Goods(name, price)); // 생성자를통해 지리스트에 상품명 가격넣어줌. dto로 만들어 컬랙션에 넣어줌 
		session.setAttribute("list", glist);// 리스트라는 이름에 지리스트라는 김밥통을 넣어줌. 키명:키밸류.
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>✔️" +name+ " 구입했습니다");
		
		out.println("<br>[<a href='myshop.html'>계속 쇼핑</a>]");
		out.println("<br>[<a href='Buy'>결제하기</a>]<br>");
		
		out.println("<p><table width='80%'>"); // 장바구니 부분. 30분간 지속됨. 
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i=0; i<glist.size(); i++) {
			Goods goods= (Goods)glist.get(i);//컬랙션에있는 내용 꺼내기
			out.println("<tr><td>" + goods.getName()+ "</td>");
			out.println("<td>"+goods.getPrice()+ "</td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

}
