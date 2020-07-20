package thinking.in.spring.ioc.dao;


import thinking.in.spring.ioc.pojo.Account;

public interface AccountDao {

	/**
     * 根据用户ID查询
	 * @param userId
     * @return
     */
	Account selectByUser(Long userId);
}
