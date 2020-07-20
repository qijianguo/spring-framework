package thinking.in.spring.ioc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.pojo.Account;
import thinking.in.spring.ioc.service.AccountService;

public class IoCTest {

	// 从Bean工厂中获取对象
	private AccountService accountService;
	@Test
	public void selectByUserTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Account account = accountService.selectByUser(1L);
	}

	@Test
	public void factoryBeanTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		// FactoryBean
		Object companyBean = applicationContext.getBean("companyBean");
		System.out.println(companyBean);  // 打印CompanyBean
		Object companyBean2 = applicationContext.getBean("&companyBean");
		System.out.println(companyBean2); // 打印CompanyFactoryBean
	}

	@Test
	public void testIoc() {
		// ApplicationContext是容器的高级接口，BeanFactory（顶级接口/根容器，规范了/定义了容器的基础行为）
		// Spring的应用上下文，官方称之为IoC容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object companyBean = applicationContext.getBean("companyBean");
		System.out.println(companyBean);
	}

}