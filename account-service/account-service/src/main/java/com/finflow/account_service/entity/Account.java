package com.finflow.account_service.entity;

import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.finflow.account_service.enums.AccountStatus;
import com.finflow.account_service.enums.CurrencyType;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
	 @Id
	    @GeneratedValue(strategy = GenerationType.UUID)
	    private UUID id;

	    @Column(name = "account_number", nullable = false, unique = true)
	    private String accountNumber;

	    @Column(name = "account_holder_name", nullable = false)
	    private String accountHolderName;

	    @Column(name = "bank_code", nullable = false)
	    private String bankCode;

	    @Enumerated(EnumType.STRING)
	    private CurrencyType currency;

	    @Column(nullable = false)
	    private BigDecimal balance;

	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private AccountStatus status;

	    @CreationTimestamp
	    @Column(name = "created_at", updatable = false)
	    private LocalDateTime createdAt;
	    
	    @Column(nullable = false)
	    private String userEmail;

		public Account() {
			super();
		}

		public Account(UUID id, String accountNumber, String accountHolderName, String bankCode, CurrencyType currency,
				BigDecimal balance, AccountStatus status, LocalDateTime createdAt) {
			super();
			this.id = id;
			this.accountNumber = accountNumber;
			this.accountHolderName = accountHolderName;
			this.bankCode = bankCode;
			this.currency = currency;
			this.balance = balance;
			this.status = status;
			this.createdAt = createdAt;
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getAccountHolderName() {
			return accountHolderName;
		}

		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}

		public String getBankCode() {
			return bankCode;
		}

		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}

		public CurrencyType getCurrency() {
			return currency;
		}

		public void setCurrency(CurrencyType currency) {
			this.currency = currency;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		public AccountStatus getStatus() {
			return status;
		}

		public void setStatus(AccountStatus status) {
			this.status = status;
		}

		public LocalDateTime getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
		
		public String getUserEmail() {
		    return userEmail;
		}

		public void setUserEmail(String userEmail) {
		    this.userEmail = userEmail;
		}

		@Override
		public String toString() {
			return "Account [id=" + id + ", accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
					+ ", bankCode=" + bankCode + ", currency=" + currency + ", balance=" + balance + ", status="
					+ status + ", createdAt=" + createdAt + "]";
		}
	    
	    
	    
}
