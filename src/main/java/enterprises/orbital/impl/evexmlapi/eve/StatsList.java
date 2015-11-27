package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;

public class StatsList<E> extends ArrayList<E> {
  private static final long serialVersionUID = -7011380987066148977L;
  private String            name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}