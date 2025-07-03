package org.ezon.msa.entity;

import java.time.LocalDateTime;

import org.ezon.msa.enums.CardTypeEnum;
import org.ezon.msa.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Long paymentId;

    @Column(nullable = false, name ="ordered_num", length = 30)
    private String orderedNum; // 주문번호(아직 주문X면 임시값/주문후 update해도 됨)

    @Column(nullable = false, name = "paid_at")
    private LocalDateTime paidAt;

    @Column(nullable = false, name = "paid_amount")
    private int paidAmount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="status", length = 20)
    private PaymentStatus status; // 예: PAID, FAILED

    @Column(name="payment_method", nullable = false, length = 20)
    private String paymentMethod; // CARD, BANK 등

    @Enumerated(EnumType.STRING)
    @Column(name="card_type", nullable = false, length = 20)
    private CardTypeEnum cardType; // 카드결제 시 카드사명 등
}