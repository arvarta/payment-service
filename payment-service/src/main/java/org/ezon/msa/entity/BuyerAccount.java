package org.ezon.msa.entity;

import java.time.LocalDateTime;

import org.ezon.msa.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "buyer_account")
public class BuyerAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buyer_account_id")
	private Long buyerAccountId;
	
	@Column(name = "buyer_id", nullable = false)
    private Long buyerId;
	
	@Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;
	
	@Column(name = "bank_account_num", nullable = false, length = 100)
    private String bankAccountNum;
	
	@Column(name = "bank_account_name", nullable = false, length = 50)
    private String bankAccountName;
	
	@Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
	
	@Column(name = "update_at")
    private LocalDateTime updatedAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false, length = 20)
    private PaymentStatus status;
	
	@Column(name = "buyer_balance", nullable = false)
    private Long buyerBalance;
}
