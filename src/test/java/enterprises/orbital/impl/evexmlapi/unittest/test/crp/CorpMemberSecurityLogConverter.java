package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberSecurityLog;
import enterprises.orbital.evexmlapi.crp.ISecurityRole;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMemberSecurityLogConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IMemberSecurityLog> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"roleHistory\" key=\"changeTime\" columns=\"changeTime,characterID,issuerID,roleLocationType\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IMemberSecurityLog next : response) {

				builder.append("<row changeTime=\"").append(
						toEveDateFormat(next.getChangeTime()));
				builder.append("\" characterID=\"").append(
						next.getCharacterID());
				builder.append("\" characterName=\"").append(
						next.getCharacterName());
				builder.append("\" issuerID=\"").append(next.getIssuerID());
				builder.append("\" issuerName=\"").append(next.getIssuerName());
				builder.append("\" roleLocationType=\"").append(
						next.getRoleLocationType());
				builder.append("\" >\n");

				builder.append("<rowset name=\"oldRoles\" key=\"roleID\" columns=\"roleID,roleName\"");
				if (next.getOldRoles().size() == 0)
					builder.append(" />\n");
				else {
					builder.append(">\n");

					for (ISecurityRole nextRole : next.getOldRoles()) {
						builder.append("<row roleID=\"").append(
								nextRole.getRoleID());
						builder.append("\" roleName=\"").append(
								nextRole.getRoleName());
						builder.append("\" />\n");
					}

					builder.append("</rowset>\n");
				}

				builder.append("<rowset name=\"newRoles\" key=\"roleID\" columns=\"roleID,roleName\"");
				if (next.getNewRoles().size() == 0)
					builder.append(" />\n");
				else {
					builder.append(">\n");

					for (ISecurityRole nextRole : next.getNewRoles()) {
						builder.append("<row roleID=\"").append(
								nextRole.getRoleID());
						builder.append("\" roleName=\"").append(
								nextRole.getRoleName());
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

}
