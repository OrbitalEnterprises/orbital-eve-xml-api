package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import enterprises.orbital.evexmlapi.crp.ICorporationSheet;
import enterprises.orbital.evexmlapi.crp.IDivision;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CorporationSheetResponse extends ApiResponse implements ICorporationSheet {
  private long                       corporationID;
  private String                     corporationName;
  private long                       allianceID;
  private String                     allianceName;
  private String                     ticker;
  private long                       ceoID;
  private String                     ceoName;
  private long                       stationID;
  private String                     stationName;
  private String                     description;
  private String                     url;
  private double                     taxRate;
  private int                        memberCount;
  private int                        memberLimit;
  private int                        shares;
  private final Map<Integer, String> divisions       = new HashMap<Integer, String>();
  private final Map<Integer, String> walletDivisions = new HashMap<Integer, String>();
  private ApiCorpLogo                logo;

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(String corporationName) {
    this.corporationName = corporationName;
  }

  @Override
  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  @Override
  public long getCeoID() {
    return ceoID;
  }

  public void setCeoID(long ceoID) {
    this.ceoID = ceoID;
  }

  @Override
  public String getCeoName() {
    return ceoName;
  }

  public void setCeoName(String ceoName) {
    this.ceoName = ceoName;
  }

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(Long allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public String getAllianceName() {
    return allianceName;
  }

  public void setAllianceName(String allianceName) {
    this.allianceName = allianceName;
  }

  @Override
  public double getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(double taxRate) {
    this.taxRate = taxRate;
  }

  @Override
  public int getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(int memberCount) {
    this.memberCount = memberCount;
  }

  @Override
  public int getMemberLimit() {
    return memberLimit;
  }

  public void setMemberLimit(int memberLimit) {
    this.memberLimit = memberLimit;
  }

  @Override
  public int getShares() {
    return shares;
  }

  public void setShares(int shares) {
    this.shares = shares;
  }

  public ApiCorpLogo getLogo() {
    return logo;
  }

  public void setLogo(ApiCorpLogo logo) {
    this.logo = logo;
  }

  public void addDivisionList(DivisionList divisionList) {
    if (divisionList.getName().equals("divisions")) {
      for (Division division : divisionList.getDivisions()) {
        this.divisions.put(division.getAccountKey(), division.getDescription());
      }
    }
    if (divisionList.getName().equals("walletDivisions")) {
      for (Division division : divisionList.getDivisions()) {
        this.walletDivisions.put(division.getAccountKey(), division.getDescription());
      }
    }

  }

  @Override
  public Collection<IDivision> getDivisions() {
    List<IDivision> result = new ArrayList<IDivision>();
    for (Entry<Integer, String> next : divisions.entrySet()) {
      final int key = next.getKey();
      final String description = next.getValue();
      result.add(new IDivision() {

        @Override
        public int getAccountKey() {
          return key;
        }

        @Override
        public String getDescription() {
          return description;
        }

      });
    }
    return result;
  }

  @Override
  public int getLogoColor1() {
    return logo.getColor1();
  }

  @Override
  public int getLogoColor2() {
    return logo.getColor2();
  }

  @Override
  public int getLogoColor3() {
    return logo.getColor3();
  }

  @Override
  public int getLogoGraphicID() {
    return logo.getGraphicID();
  }

  @Override
  public int getLogoShape1() {
    return logo.getShape1();
  }

  @Override
  public int getLogoShape2() {
    return logo.getShape2();
  }

  @Override
  public int getLogoShape3() {
    return logo.getShape3();
  }

  @Override
  public Collection<IDivision> getWalletDivisions() {
    List<IDivision> result = new ArrayList<IDivision>();
    for (Entry<Integer, String> next : walletDivisions.entrySet()) {
      final int key = next.getKey();
      final String description = next.getValue();
      result.add(new IDivision() {

        @Override
        public int getAccountKey() {
          return key;
        }

        @Override
        public String getDescription() {
          return description;
        }

      });
    }
    return result;
  }
}