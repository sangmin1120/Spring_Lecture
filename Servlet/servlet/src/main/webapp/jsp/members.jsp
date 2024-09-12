<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: sangm
  Date: 24. 9. 7.
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    </thead>
    <tbody>
      <%
        for (Member member : members) {
          out.write("    <tr>");
          out.write("        <td>" + member.getId() + "</td>");
          out.write("        <td>" + member.getUsername() + "</td>");
          out.write("        <td>" + member.getAge() + "</td>");
          out.write("    </tr>");
        }
      %>
  </table>
</body>
</html>
