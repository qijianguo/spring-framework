package thinking.in.spring.ioc.factory;

import org.springframework.beans.factory.FactoryBean;
import thinking.in.spring.ioc.pojo.Company;

public class CompanyFactoryBean implements FactoryBean<Company> {

	private String companyInfo;

	@Override
	public Company getObject() throws Exception {
		Company company = new Company();
		if (company == null) {
			throw new NullPointerException("companyInfo must not be null !");
		}
		String[] split = companyInfo.split(",");
		String name = split[0];
		String address = split[1];
		Integer scale = Integer.parseInt(split[2]);
		company.setName(name);
		company.setAddress(address);
		company.setScale(scale);
		return company;
	}

	@Override
	public Class<?> getObjectType() {
		return Company.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
}
