package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

public class SecurityRoleBag {
	private String name;
	private final Collection<ApiSecurityRole> securityRoles = new ArrayList<ApiSecurityRole>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addSecurityRole(ApiSecurityRole securityRole) {
		securityRoles.add(securityRole);
	}

	public Collection<ApiSecurityRole> getSecurityRoles() {
		return securityRoles;
	}
}