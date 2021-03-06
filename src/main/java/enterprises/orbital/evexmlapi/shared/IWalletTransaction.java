package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IWalletTransaction.class)
public interface IWalletTransaction {
  public long getCharacterID();

  public String getCharacterName();

  public long getClientID();

  public String getClientName();

  public BigDecimal getPrice();

  public long getQuantity();

  public long getStationID();

  public String getStationName();

  public Date getTransactionDateTime();

  public String getTransactionFor();

  public long getTransactionID();

  public String getTransactionType();

  public int getTypeID();

  public String getTypeName();

  public long getJournalTransactionID();

  public int getClientTypeID();
}
