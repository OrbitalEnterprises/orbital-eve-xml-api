package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;

public class ContactList extends ArrayList<ApiContact> {
  private static final long serialVersionUID = 1L;
  private String            name;
  private String            key;
  private String            columns;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getColumns() {
    return columns;
  }

  public void setColumns(String columns) {
    this.columns = columns;
  }
}