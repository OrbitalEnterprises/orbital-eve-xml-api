package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;

public interface IMemberSecurity {
	public long getCharacterID();

	public Collection<ISecurityRole> getGrantableRoles();

	public Collection<ISecurityRole> getGrantableRolesAtBase();

	public Collection<ISecurityRole> getGrantableRolesAtHQ();

	public Collection<ISecurityRole> getGrantableRolesAtOther();

	public String getName();

	public Collection<ISecurityRole> getRoles();

	public Collection<ISecurityRole> getRolesAtBase();

	public Collection<ISecurityRole> getRolesAtHQ();

	public Collection<ISecurityRole> getRolesAtOther();

	public Collection<ISecurityTitle> getTitles();

}
