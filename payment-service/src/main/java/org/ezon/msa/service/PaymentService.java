package org.ezon.msa.service;

import java.time.LocalDateTime;

import org.ezon.msa.dto.PaymentRequestDto;
import org.ezon.msa.dto.PaymentResponseDto;
import org.ezon.msa.entity.Payment;
import org.ezon.msa.enums.CardTypeEnum;
import org.ezon.msa.enums.PaymentStatus;
import org.ezon.msa.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
	
	@Autowired
    private PaymentRepository paymentRepository;

    // 결제 등록 (결제 성공했다고 가정)
    @Transactional
    public PaymentResponseDto createPayment(PaymentRequestDto req) {
        Payment payment = Payment.builder()
                .orderedNum("") // 주문 생성 전이므로 임시 빈값, 주문 후 update하거나 orderNum 받아서 저장도 가능
                .paidAt(LocalDateTime.now())
                .paidAmount(req.getAmount())
                .status(PaymentStatus.PAID)
                .paymentMethod(req.getMethod())
                .cardType(CardTypeEnum.valueOf(req.getCardType()))
                .build();
        System.out.println("payment " + payment);
        paymentRepository.save(payment);
        return new PaymentResponseDto(payment.getPaymentId());
    }
    
    public void deleteById(Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new IllegalArgumentException("존재하지 않는 결제입니다.");
        }
        paymentRepository.deleteById(id);
    }
    
    @Transactional
    public void updateOrderNum(Long paymentId, String orderNum) {
        Payment payment = paymentRepository.findById(paymentId)
            .orElseThrow(() -> new IllegalArgumentException("결제정보 없음"));
        payment.setOrderedNum(orderNum);
        paymentRepository.save(payment);
    }
    
    public Payment getPaymentInfoByOrderNum(String orderNum) {
    	return paymentRepository.findByOrderedNum(orderNum).orElseThrow(
    		() -> new IllegalArgumentException("해당 주문번호의 결제 정보가 없습니다.")
    	);
    }
    
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("결제 정보 없음"));
    }

}
