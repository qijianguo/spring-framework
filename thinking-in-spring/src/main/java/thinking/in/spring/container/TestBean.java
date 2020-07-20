package thinking.in.spring.container;

public class TestBean {

	private String name = "Angus";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TestBean{" +
				"name='" + name + '\'' +
				'}';
	}
}
