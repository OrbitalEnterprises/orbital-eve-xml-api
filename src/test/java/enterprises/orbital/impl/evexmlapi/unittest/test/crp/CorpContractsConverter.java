package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IContract;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpContractsConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IContract> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder
        .append("<rowset name=\"contractList\" key=\"contractID\" columns=\"contractID,issuerID,issuerCorpID,assigneeID,acceptorID,startStationID,endStationID,type,status,title,forCorp,availability,dateIssued,dateExpired,dateAccepted,numDays,dateCompleted,price,reward,collateral,buyout,volume\"");
    if (response.size() > 0) {
      builder.append(">\n");

      for (IContract next : response) {
        builder.append("<row contractID=\"").append(next.getContractID());
        builder.append("\" issuerID=\"").append(next.getIssuerID());
        builder.append("\" issuerCorpID=\"").append(next.getIssuerCorpID());
        builder.append("\" assigneeID=\"").append(next.getAssigneeID());
        builder.append("\" acceptorID=\"").append(next.getAcceptorID());
        builder.append("\" startStationID=\"").append(next.getStartStationID());
        builder.append("\" endStationID=\"").append(next.getEndStationID());
        builder.append("\" type=\"").append(next.getType());
        builder.append("\" status=\"").append(next.getStatus());
        builder.append("\" title=\"").append(next.getTitle());
        builder.append("\" forCorp=\"").append(next.isForCorp() ? 1 : 0);
        builder.append("\" availability=\"").append(next.getAvailability());
        builder.append("\" dateIssued=\"").append(next.getDateIssued() != null ? toEveDateFormat(next.getDateIssued()) : "");
        builder.append("\" dateExpired=\"").append(next.getDateExpired() != null ? toEveDateFormat(next.getDateExpired()) : "");
        builder.append("\" dateAccepted=\"").append(next.getDateAccepted() != null ? toEveDateFormat(next.getDateAccepted()) : "");
        builder.append("\" numDays=\"").append(next.getNumDays());
        builder.append("\" dateCompleted=\"").append(next.getDateCompleted() != null ? toEveDateFormat(next.getDateCompleted()) : "");
        builder.append("\" price=\"").append(String.format("%.2f", next.getPrice()));
        builder.append("\" reward=\"").append(String.format("%.2f", next.getReward()));
        builder.append("\" collateral=\"").append(String.format("%.2f", next.getCollateral()));
        builder.append("\" buyout=\"").append(String.format("%.2f", next.getBuyout()));
        builder.append("\" volume=\"").append(next.getVolume());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");

    } else {
      builder.append(" />\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
