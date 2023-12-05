package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "hello.servlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // tomcat 라이브러리 등 was
        System.out.println("response = " + response);

        // 요청
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답
        response.setContentType("text/plain"); // header 정보 - 컨텐트 타입
        response.setCharacterEncoding("UTF-8"); // header 정보 - 인코딩 정보
        response.getWriter().write("hello " + username); // write() -> http message body 에 작성
    }
}
