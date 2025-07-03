<!-- index.jsp -->
<!DOCTYPE html>
<html>
<head>
  	<meta charset="UTF-8">
  	<title>결제 테스트</title>
  	<script src="https://js.tosspayments.com/v1/payment/co"></script>
</head>
<body>

<h2>결제 테스트</h2>
<button id="payment-button">결제하기</button>

<script>
	const clientKey = "test_ck_LIDJaYngroXvMBI4ZEGv8ezGdRpX"; // 클라이언트 키
		
	const tossPayments = TossPayments(clientKey);

	document.getElementById("payment-button").addEventListener("click", function () {
   		tossPayments.requestPayment("카드", {
   			amount: 5000,
   			orderId: "order-" + new Date().getTime(),
   			orderName: "테스트상품",
   			customerName: "홍길동",
   			successUrl: "http://localhost:10600/success",
   			failUrl: "http://localhost:10600/fail"
    	});
  	});
</script>

</body>
</html>
