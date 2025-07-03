package org.ezon.msa.controller;

import java.util.Map;

import org.ezon.msa.dto.PaymentRequestDto;
import org.ezon.msa.dto.PaymentResponseDto;
import org.ezon.msa.entity.Payment;
import org.ezon.msa.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDto> createPayment(@RequestBody PaymentRequestDto req) {
    	System.out.println("PaymentRequestDto: " + req);
        PaymentResponseDto resp = paymentService.createPayment(req);
        return ResponseEntity.ok(resp);
    }
    
    @DeleteMapping("/{paymentId}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long paymentId) {
        try {
            paymentService.deleteById(paymentId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PutMapping("/{paymentId}/order-num")
    public ResponseEntity<Void> updateOrderNum(@PathVariable Long paymentId, @RequestBody Map<String, String> req) {
        String orderNum = req.get("orderNum");
        paymentService.updateOrderNum(paymentId, orderNum);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/order/{orderNum}")
    public ResponseEntity<Payment> getPaymentByOrderNum(@PathVariable String orderNum) {
    	Payment payment = paymentService.getPaymentInfoByOrderNum(orderNum);
    	return ResponseEntity.ok(payment);
    }
    
    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long paymentId) {
        Payment payment = paymentService.getPaymentById(paymentId);
        return ResponseEntity.ok(payment);
    }

}
