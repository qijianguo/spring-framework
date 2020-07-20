package thinking.in.spring.ioc.service;

import thinking.in.spring.ioc.pojo.Account;

public interface AccountService {

	Account selectByUser(Long userId);

	void transfer(Long userA, Long userB, int account);
}
