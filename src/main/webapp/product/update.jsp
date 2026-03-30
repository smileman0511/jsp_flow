<%@page import="com.app.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>
	<%
		ProductVO product = (ProductVO)request.getAttribute("product");
	%>
	<form action="/flow/update-ok.product" method="post">
		<input name="id" type="hidden" value=>
		<div>
			<span>상품명</span>
			<input name="productName" value="<%=product.getProductName() %>" />
		</div>
		<div>
			<span>상품 가격</span>
			<input name="productPrice" value="<%=product.getProductPrice() %>" />
		</div>
		<div>
			<span>상품 재고</span>
			<input name="productStock" value="<%=product.getProductStock() %>"/>
		</div>
		<button>상품 수정</button>
	</form>
</body>



</html>