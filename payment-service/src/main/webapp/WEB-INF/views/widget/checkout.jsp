<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>결제 요청</title>
</head>
<body>
    <h1>결제 테스트 페이지</h1>
    <form action="/payment/pay" method="post">
        <label>주문번호:</label><br>
        <input type="text" name="partnerOrderId" value="ORDER123"><br><br>
        
        <label>상품명:</label><br>
        <input type="text" name="itemName" value="테스트 상품"><br><br>

        <label>결제금액:</label><br>
        <input type="number" name="totalAmount" value="10000"><br><br>

        <button type="submit">결제하기</button>
    </form>
</body>
</html>
