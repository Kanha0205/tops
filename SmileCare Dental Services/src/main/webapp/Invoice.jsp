<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
    <title>Invoice</title>
</head>
<body>

<h2>Patient Invoice</h2>

<p>Patient Name: ${name}</p>
<p>Treatment: ${treatment}</p>

<p>Treatment Cost: ${tCost}</p>
<p>Medicine Cost: ${mCost}</p>
<p>Tax: ${tax}</p>
<p>Discount: ${discount}</p>

<hr>

<h3>Total Amount: ${total}</h3>

</body>
</html>