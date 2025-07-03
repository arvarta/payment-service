package org.ezon.msa.enums;

public enum PaymentStatus {
	REQUESTED,     // 결제 요청됨 (버튼 클릭 직후)
    PAID,          // 결제 완료
    FAILED,        // 결제 실패 (잔액 부족 등)
    CANCELLED,     // 결제 취소
    REFUNDED       // 환불 완료
}
