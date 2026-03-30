<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
</head>
<body>
	<table border="1">
      <tr>
         <th>상품번호</th>
         <th>상품명</th>
         <th>상품가격</th>
         <th>상품재고</th>
      </tr>
      <tr>
         <td><c:out escapeXml="true" value="${product.id}"></c:out></td>
         <td><c:out escapeXml="true" value="${product.productName}"></c:out></td>
         <td><c:out escapeXml="true" value="${product.productPrice}"></c:out></td>
         <td><c:out escapeXml="true" value="${product.productStock}"></c:out></td>
      </tr>
   </table> 
   <a href="/flow/update.product?id=${product.id}">수정하기</a>   
   <a href="/flow/delete-ok.product?id=${product.id}">삭제하기</a> 
</body>
</html>