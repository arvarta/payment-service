package org.ezon.msa.repository;

import java.util.Optional;

import org.ezon.msa.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
	Optional<Payment> findByOrderedNum(String orderedNum);
}
