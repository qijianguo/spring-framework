package thinking.in.spring.container;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class BeanFactoryTest {

	@Test
	public void testBeanLoad() throws IOException {

		Resource resource = new ClassPathResource("beanFactoryTest.xml");
		/*boolean exists = resource.exists();
		try (InputStream inputStream = resource.getInputStream()){
		} catch (Exception e) {
		}*/
		// 读取XML文件
		BeanFactory bf = new XmlBeanFactory(resource);
		// 更加XML中的配置找到对应类的的配置，并实例化
		TestBean testBean = (TestBean) bf.getBean("testBean");
		// 调用实例
		System.out.println(testBean);
		assertThat(testBean.getName()).isEqualTo("Angus");
	}

}
