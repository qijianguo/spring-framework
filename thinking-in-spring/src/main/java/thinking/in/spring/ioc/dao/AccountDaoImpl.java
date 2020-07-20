package thinking.in.spring.ioc.dao;


import thinking.in.spring.ioc.pojo.Account;

import java.math.BigDecimal;

public class AccountDaoImpl implements AccountDao {

	@Override
	public Account selectByUser(Long userId) {
		Account account = new Account(1L, new BigDecimal(1000));
		return account;
	}
}
