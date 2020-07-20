package thinking.in.spring.ioc.pojo;

import java.math.BigDecimal;

public class Account {

	private Long userId;

	private BigDecimal balance;

	public Account() {
	}

	public Account(Long userId, BigDecimal balance) {
		this.userId = userId;
		this.balance = balance;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account{" +
				"userId=" + userId +
				", balance=" + balance +
				'}';
	}
}
