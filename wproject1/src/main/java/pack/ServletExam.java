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


@WebServlet("/ServletExam")
public class ServletExam extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bunho= Integer.parseInt(request.getParameter("bunho"));
		String name = request.getParameter("name");
		int kor= Integer.parseInt(request.getParameter("kor"));
		int eng= Integer.parseInt(request.getParameter("eng"));
		
		HttpSession session = request.getSession(true); //세션 유무체크>만들기
	
		ArrayList<Scores> slist= (ArrayList<Scores>)session.getAttribute("list");
		
		if(slist== null) slist= new ArrayList<Scores>(); // 중복제거!!! 
		
		slist.add(new Scores(bunho, name, kor, eng));
		session.setAttribute("list", slist);
		
		//클라이언트로 출력
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>세션처리 결과</h2>");
		
		out.println("<p><width='70%'>"); // 장바구니 부분. 30분간 지속됨. 
		out.println("<tr><th>번호</th><th>이름</th><th>국어</th><th>영어</th><th>총점</th></tr>");
		
		int count=0; 
		int total=0;
		for(int i=0; i<slist.size(); i++) {
			Scores scores= (Scores)slist.get(i);//컬랙션에있는 내용 꺼내기
			out.println("<tr><td>" + scores.getBunho()+ "</td>");
			out.println("<td>" + scores.getName()+ "</td>");
			out.println("<td>" + scores.getKor()+ "</td>");
			out.println("<td>" + scores.getEng()+ "</td>");
			total= scores.getKor()+ scores.getEng();
			count++;
			out.println("<td>" + total + "</td></tr>");
		}
		out.println("<tr><td colspan='5'> 인원수: " +count+ "</td></tr>");
		
		// 세션삭제 //session.removeAttribute("list");
		
		out.println("<br><a href='Exam.html'>새로 입력</a>");
		out.println("<br><a href='.html'>세션삭제</a>");//???
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}

}
