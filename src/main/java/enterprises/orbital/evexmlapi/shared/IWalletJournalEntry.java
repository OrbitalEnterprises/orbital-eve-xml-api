package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IWalletJournalEntry.class)
public interface IWalletJournalEntry {
  public BigDecimal getAmount();

  public long getArgID1();

  public String getArgName1();

  public BigDecimal getBalance();

  public Date getDate();

  public long getOwnerID1();

  public long getOwnerID2();

  public String getOwnerName1();

  public String getOwnerName2();

  public String getReason();

  public long getRefID();

  public int getRefTypeID();

  public BigDecimal getTaxAmount();

  public long getTaxReceiverID();
}
