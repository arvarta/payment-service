package org.ezon.msa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
    private Long userId;
    private int amount;
    private String method;     // CARD, BANK 등
    private String cardType;   // 카드결제시 카드사명(선택)
}
