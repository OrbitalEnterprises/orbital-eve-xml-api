package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ICustomsOffice;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpCustomsOfficesConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<ICustomsOffice> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"pocos\" key=\"itemID\" columns=\"itemID,solarSystemID,solarSystemName,reinforceHour,allowAlliance,allowStandings,standingLevel,taxRateAlliance,taxRateCorp,taxRateStandingHigh,taxRateStandingGood,taxRateStandingNeutral,taxRateStandingBad,taxRateStandingHorrible\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (ICustomsOffice next : response) {
        builder.append("<row itemID=\"").append(next.getItemID());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" solarSystemName=\"").append(next.getSolarSystemName());
        builder.append("\" reinforceHour=\"").append(next.getReinforceHour());
        builder.append("\" allowAlliance=\"").append(next.isAllowAlliance() ? "1" : "0");
        builder.append("\" allowStandings=\"").append(next.isAllowStandings() ? "1" : "0");
        double standingLevel = next.getStandingLevel();
        builder.append("\" standingLevel=\"").append(standingLevel == Math.round(standingLevel) ? String.format("%.0f", standingLevel) : String
                                                         .valueOf(standingLevel));
        builder.append("\" taxRateAlliance=\"").append(next.getTaxRateAlliance() == 0.0 ? "0" : String.valueOf(next.getTaxRateAlliance()));
        builder.append("\" taxRateCorp=\"").append(next.getTaxRateCorp() == 0.0 ? "0" : String.valueOf(next.getTaxRateCorp()));
        builder.append("\" taxRateStandingHigh=\"").append(next.getTaxRateStandingHigh() == 0.0 ? "0" : String.valueOf(next.getTaxRateStandingHigh()));
        builder.append("\" taxRateStandingGood=\"").append(next.getTaxRateStandingGood() == 0.0 ? "0" : String.valueOf(next.getTaxRateStandingGood()));
        builder.append("\" taxRateStandingNeutral=\"").append(next.getTaxRateStandingNeutral() == 0.0 ? "0" : String.valueOf(next.getTaxRateStandingNeutral()));
        builder.append("\" taxRateStandingBad=\"").append(next.getTaxRateStandingBad() == 0.0 ? "0" : String.valueOf(next.getTaxRateStandingBad()));
        builder.append("\" taxRateStandingHorrible=\"").append(next.getTaxRateStandingHorrible() == 0.0 ? "0" : String.valueOf(next
                                                                   .getTaxRateStandingHorrible()));
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }

}
