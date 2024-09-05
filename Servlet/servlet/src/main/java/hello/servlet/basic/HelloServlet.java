package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name="helloServlet" , urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);


        // 요청
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답 , 톰캣이 많이 만들어 준다...
            // 헤더 contentType
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
            //
        response.getWriter().write("hello " + username);
    }
}
