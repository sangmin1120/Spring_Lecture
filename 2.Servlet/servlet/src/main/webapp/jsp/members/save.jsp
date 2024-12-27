<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%--
  Created by IntelliJ IDEA.
  User: sangm
  Date: 24. 9. 7.
  Time: 오후 2:24
  To change this template use File | Settings | File Templates.
--%>
<%
  // request , response 그냥 사용 가능
  MemberRepository memberRepository = MemberRepository.getInstance();

  System.out.println("MemberSaveServlet.service");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username,age);
  memberRepository.save(member);
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    성공
    <ul>
      <li>id=<%=member.getId()%></li>
      <li>id=<%=member.getUsername()%></li>
      <li>id=<%=member.getAge()%></li>
    </ul>
  <a href="/index.html">메인</a>
  </body>
</html>
