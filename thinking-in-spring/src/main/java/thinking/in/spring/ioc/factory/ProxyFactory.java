package thinking.in.spring.ioc.factory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象工厂：生成代理对象
 */
public class ProxyFactory {

	private static ProxyFactory instance;

	private ProxyFactory() {
	}

	public static ProxyFactory getInstance() {
		if (instance == null) {
			instance = new ProxyFactory();
		}
		return instance;
	}

	/**
	 * 获取代理对象
	 * @param obj 委托对象
	 * @return 代理对象
	 */
	public Object getProxy(Object obj) {
		Object proxyObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
				(proxy, method, args) -> {
			System.out.println("------增强逻辑：设置事务不自动提交-------");
			Object invoke = method.invoke(obj, args);
			System.out.println("------增强逻辑：提交事务-----------");
			return invoke;
		});
		return proxyObj;
	}

	/**
	 * 获取代理对象
	 * @param obj 委托对象
	 * @return 代理对象
	 */
	public Object getCglibProxy(Object obj) {
		Object proxyObj = Enhancer.create(obj.getClass(), new MethodInterceptor() {
			@Override
			public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
				System.out.println("------增强逻辑：设置事务不自动提交-------");
				Object invoke = method.invoke(obj, objects);
				System.out.println("------增强逻辑：提交事务-----------");
				return invoke;
			}
		});
		return proxyObj;
	}
}
