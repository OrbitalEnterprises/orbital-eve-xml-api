package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IIndustryJob;
import enterprises.orbital.evexmlapi.shared.IStanding;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpIndustryJobsConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IIndustryJob> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      builder
          .append("<rowset name=\"jobs\" key=\"jobID\" columns=\"jobID,installerID,installerName,facilityID,solarSystemID,solarSystemName,stationID,activityID,blueprintID,blueprintTypeID,blueprintTypeName,blueprintLocationID,outputLocationID,runs,cost,teamID,licensedRuns,probability,productTypeID,productTypeName,status,timeInSeconds,startDate,endDate,pauseDate,completedDate,completedCharacterID,successfulRuns\">\n");

      for (IIndustryJob next : response) {
        builder.append("<row jobID=\"").append(next.getJobID());
        builder.append("\" installerID=\"").append(next.getInstallerID());
        builder.append("\" installerName=\"").append(next.getInstallerName());
        builder.append("\" facilityID=\"").append(next.getFacilityID());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" solarSystemName=\"").append(next.getSolarSystemName());
        builder.append("\" stationID=\"").append(next.getStationID());
        builder.append("\" activityID=\"").append(next.getActivityID());
        builder.append("\" blueprintID=\"").append(next.getBlueprintID());
        builder.append("\" blueprintTypeID=\"").append(next.getBlueprintTypeID());
        builder.append("\" blueprintTypeName=\"").append(next.getBlueprintTypeName());
        builder.append("\" blueprintLocationID=\"").append(next.getBlueprintLocationID());
        builder.append("\" outputLocationID=\"").append(next.getOutputLocationID());
        builder.append("\" runs=\"").append(next.getRuns());
        builder.append("\" cost=\"").append(String.format("%.2f", next.getCost()));
        builder.append("\" teamID=\"").append(next.getTeamID());
        builder.append("\" licensedRuns=\"").append(next.getLicensedRuns());
        builder.append("\" probability=\"");
        if (next.getProbability() == (int) next.getProbability())
          builder.append((int) next.getProbability());
        else
          builder.append(next.getProbability());
        builder.append("\" productTypeID=\"").append(next.getProductTypeID());
        builder.append("\" productTypeName=\"").append(next.getProductTypeName());
        builder.append("\" status=\"").append(next.getStatus());
        builder.append("\" timeInSeconds=\"").append(next.getTimeInSeconds());
        builder.append("\" startDate=\"").append(toEveDateFormat(next.getStartDate()));
        builder.append("\" endDate=\"").append(toEveDateFormat(next.getEndDate()));
        builder.append("\" pauseDate=\"");
        if (next.getPauseDate() == null)
          builder.append("0001-01-01 00:00:00");
        else
          builder.append(toEveDateFormat(next.getPauseDate()));
        builder.append("\" completedDate=\"");
        if (next.getCompletedDate() == null)
          builder.append("0001-01-01 00:00:00");
        else
          builder.append(toEveDateFormat(next.getCompletedDate()));
        builder.append("\" completedCharacterID=\"").append(next.getCompletedCharacterID());
        builder.append("\" successfulRuns=\"").append(next.getSuccessfulRuns());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");

      builder.append("</result>\n");
    }

    convertCloser(request, builder);
    return builder.toString();
  }

  protected static void dumpStanding(IStanding standing, StringBuilder builder) {
    builder.append("<row fromID=\"").append(standing.getFromID());
    builder.append("\" fromName=\"").append(standing.getFromName());
    builder.append("\" standing=\"").append(String.format("%1.2f", standing.getStanding()));
    builder.append("\" />\n");
  }
}
