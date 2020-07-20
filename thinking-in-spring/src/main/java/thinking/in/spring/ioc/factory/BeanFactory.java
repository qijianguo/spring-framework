package thinking.in.spring.ioc.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工厂类，生成对象（使用反射机制）
 */
public class BeanFactory {

	private static Map<String, Object> map = new HashMap<>();

	static {
		/*InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
		SAXReader saxReader = new SAXReader();
		try {
			Document read = saxReader.read(resourceAsStream);
			*//*
			   // 表示不考虑层级，将所有节点遍历
			   / 表示从根节点选取
			   . 选取当前节点
			   .. 选取当前节点的父节点
			   @ 选取属性
			*//*
			Element rootElement = read.getRootElement();
			List<Element> list = rootElement.selectNodes("//bean");
			for (Element element : list) {
				String id = element.attributeValue("id");
				String clazz = element.attributeValue("class");
				Class<?> aClass = Class.forName(clazz);
				Object o = aClass.newInstance();
				map.put(id, o);
			}
			// 设置依赖关系
			List<Element> properties = rootElement.selectNodes("//property");
			for (Element property : properties) {
				String name = property.attributeValue("name");
				String ref = property.attributeValue("ref");
				Element parent = property.getParent();
				String parentId = parent.attributeValue("id");
				Object parentObj = map.get(parentId);
				for (Method method : parentObj.getClass().getMethods()) {
					if (("set" + name).equalsIgnoreCase(method.getName())) {
						method.invoke(parentObj, map.get(ref));
					}
				}
				map.put(parentId, parentObj);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}*/
	}

	public static Object getBean(String id) {
		return map.get(id);
	}
}
