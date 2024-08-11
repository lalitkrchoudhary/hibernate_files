package in.lalit.dao;

import java.util.List;
import in.lalit.model.InsurancePolicy;

public interface InsurancePolicyDao {
	public List<InsurancePolicy> getPolicyByTenure(int start, int end);

}
