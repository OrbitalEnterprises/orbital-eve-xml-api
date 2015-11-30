package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

public class CharacterSheetRowsetDataCollector {
  public final String                         type;
  public final List<CharacterSheetRowsetData> stuff = new ArrayList<CharacterSheetRowsetData>();

  public CharacterSheetRowsetDataCollector(String t) {
    type = t;
  }

  public void addData(CharacterSheetRowsetData d) {
    stuff.add(d);
  }
}
