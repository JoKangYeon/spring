<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title></title>
</head>
<body>
<%@include file="/WEB-INF/inc/top.jsp" %>

<ul class="nav nav-tabs" role="tablist" id="myTab">
  <li role="presentation" class="active">
      <a href="free" aria-controls="chProfile" role="tab" data-toggle="tab">free</a>
  </li>
  <li role="presentation">
      <a href="member" aria-controls="chAlcohol" role="tab" data-toggle="tab">member</a>
  </li>
</ul>
<div class="tab-content">   <%-- free 랑 memeber 화면 들어가는 div--%>

</div>

</body>
<script>
    $(document).ready(function () {
        $("#myTab").on("click" , "a" , function (e){
            e.preventDefault();
            console.log(this);
            let href = $(this).attr("href");
            console.log(href);
            let url = "";
            if(href ==="member"){
                url = "/about/memberList";
            }else if(href === "free"){
                url = "/about/freeList";
            }
            $(".tab-content").load(url);

        })
    })
</script>


</html>