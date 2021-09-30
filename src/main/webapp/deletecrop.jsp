<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.farm.utility.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String cid=request.getParameter("id");
if(cid!=null)
{
	int userid=Integer.parseInt(cid);
	Connection con=DBConnect.getConn();
	String sql = "DELETE FROM F_CROPS WHERE ID=" + userid;
	PreparedStatement ps = con.prepareStatement(sql);
	int i = ps.executeUpdate();
	if (i > 0) {
%>
<jsp:forward page="/viewaddedcrops.jsp" />


<%
} else
%>
<jsp:forward page="/viewaddedcrops.jsp" />
<%
}
%>
</body>
</html>