package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IRole;
import enterprises.orbital.evexmlapi.crp.ITitle;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpTitlesConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<ITitle> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"titles\" key=\"titleID\" columns=\"titleID,titleName\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ITitle next : response) {

				builder.append("<row titleID=\"").append(next.getTitleID());
				builder.append("\" titleName=\"").append(next.getTitleName());
				builder.append("\" >\n");

				builder.append("<rowset name=\"roles\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getRoles(), builder);
				builder.append("<rowset name=\"grantableRoles\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getGrantableRoles(), builder);
				builder.append("<rowset name=\"rolesAtHQ\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getRolesAtHQ(), builder);
				builder.append("<rowset name=\"grantableRolesAtHQ\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getGrantableRolesAtHQ(), builder);
				builder.append("<rowset name=\"rolesAtBase\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getRolesAtBase(), builder);
				builder.append("<rowset name=\"grantableRolesAtBase\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getGrantableRolesAtBase(), builder);
				builder.append("<rowset name=\"rolesAtOther\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getRolesAtOther(), builder);
				builder.append("<rowset name=\"grantableRolesAtOther\" key=\"roleID\" columns=\"roleID,roleName,roleDescription\"");
				outputRoles(next.getGrantableRolesAtOther(), builder);

				builder.append("</row>\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}

	protected static void outputRoles(Collection<IRole> roles,
			StringBuilder builder) {
		if (roles.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IRole next : roles) {
				builder.append("<row roleID=\"").append(next.getRoleID());
				builder.append("\" roleName=\"").append(next.getRoleName());
				builder.append("\" roleDescription=\"").append(
						next.getRoleDescription());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}
}
