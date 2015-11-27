package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberSecurity;
import enterprises.orbital.evexmlapi.crp.ISecurityRole;
import enterprises.orbital.evexmlapi.crp.ISecurityTitle;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMemberSecurityConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IMemberSecurity> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"members\" key=\"characterID\" columns=\"characterID, name\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IMemberSecurity next : response) {
				builder.append("<row characterID=\"").append(
						next.getCharacterID());
				builder.append("\" name=\"").append(next.getName());
				builder.append("\" >\n");

				builder.append("<rowset name=\"roles\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getRoles(), builder);

				builder.append("<rowset name=\"grantableRoles\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getGrantableRoles(), builder);

				builder.append("<rowset name=\"rolesAtHQ\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getRolesAtHQ(), builder);

				builder.append("<rowset name=\"grantableRolesAtHQ\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getGrantableRolesAtHQ(), builder);

				builder.append("<rowset name=\"rolesAtBase\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getRolesAtBase(), builder);

				builder.append("<rowset name=\"grantableRolesAtBase\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getGrantableRolesAtBase(), builder);

				builder.append("<rowset name=\"rolesAtOther\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getRolesAtOther(), builder);

				builder.append("<rowset name=\"grantableRolesAtOther\" key=\"roleID\" columns=\"roleID,roleName\"");
				outputRoles(next.getGrantableRolesAtOther(), builder);

				builder.append("<rowset name=\"titles\" key=\"titleID\" columns=\"titleID,titleName\"");
				if (next.getTitles().size() == 0)
					builder.append(" />\n");
				else {
					builder.append(">\n");
					for (ISecurityTitle nextTitle : next.getTitles()) {
						builder.append("<row titleID=\"").append(
								nextTitle.getTitleID());
						builder.append("\" titleName=\"").append(
								nextTitle.getTitleName());
						builder.append("\" />\n");
					}
					builder.append("</rowset>\n");
				}

				builder.append("</row>\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}

	protected static void outputRoles(Collection<ISecurityRole> roles,
			StringBuilder builder) {
		if (roles.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ISecurityRole nextRole : roles) {
				builder.append("<row roleID=\"").append(nextRole.getRoleID());
				builder.append("\" roleName=\"").append(nextRole.getRoleName());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}
}
