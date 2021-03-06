package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharWalletTransactionsConverter extends ResponseConverter {

  public static String convert(
                               ICharacterAPI request,
                               Collection<IWalletTransaction> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"transactions\" key=\"transactionID\" columns=\"transactionDateTime,transactionID,quantity,typeName,typeID,price,clientID,clientName,stationID,stationName,transactionType,transactionFor,journalTransactionID,clientTypeID\"");

    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IWalletTransaction next : response) {

        builder.append("<row transactionDateTime=\"").append(toEveDateFormat(next.getTransactionDateTime()));
        builder.append("\" transactionID=\"").append(next.getTransactionID());
        builder.append("\" quantity=\"").append(next.getQuantity());
        builder.append("\" typeName=\"").append(next.getTypeName());
        builder.append("\" typeID=\"").append(next.getTypeID());
        builder.append("\" price=\"").append(String.format("%.2f", next.getPrice()));
        builder.append("\" clientID=\"").append(next.getClientID());
        builder.append("\" clientName=\"").append(next.getClientName());
        builder.append("\" stationID=\"").append(next.getStationID());
        builder.append("\" stationName=\"").append(next.getStationName());
        builder.append("\" transactionType=\"").append(next.getTransactionType());
        builder.append("\" transactionFor=\"").append(next.getTransactionFor());
        builder.append("\" journalTransactionID=\"").append(next.getJournalTransactionID());
        builder.append("\" clientTypeID=\"").append(next.getClientTypeID());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
