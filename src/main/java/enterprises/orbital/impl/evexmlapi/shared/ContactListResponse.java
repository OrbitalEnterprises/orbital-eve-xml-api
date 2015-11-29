package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enterprises.orbital.evexmlapi.shared.IContact;
import enterprises.orbital.evexmlapi.shared.IContactLabel;
import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContactListResponse extends ApiResponse implements IContactSet {
  private Map<String, ContactList> contactLists = new HashMap<String, ContactList>();

  public void addContactList(ContactList contactList) {
    contactLists.put(contactList.getName(), contactList);
  }

  @Override
  public List<IContact> getContacts() {
    List<IContact> result = new ArrayList<IContact>();
    if (contactLists.containsKey("contactList")) result.addAll(contactLists.get("contactList"));
    return result;
  }

  @Override
  public List<IContact> getCorporateContacts() {
    List<IContact> result = new ArrayList<IContact>();
    if (contactLists.containsKey("corporateContactList")) result.addAll(contactLists.get("corporateContactList"));
    return result;
  }

  @Override
  public List<IContact> getAllianceContacts() {
    List<IContact> result = new ArrayList<IContact>();
    if (contactLists.containsKey("allianceContactList")) result.addAll(contactLists.get("allianceContactList"));
    return result;
  }

  @Override
  public List<IContactLabel> getContactLabels() {
    List<IContactLabel> result = new ArrayList<IContactLabel>();
    if (contactLists.containsKey("contactLabels")) result.addAll(contactLists.get("contactLabels"));
    return result;
  }

  @Override
  public List<IContactLabel> getCorporateContactLabels() {
    List<IContactLabel> result = new ArrayList<IContactLabel>();
    if (contactLists.containsKey("corporateContactLabels")) result.addAll(contactLists.get("corporateContactLabels"));
    return result;
  }

  @Override
  public List<IContactLabel> getAllianceContactLabels() {
    List<IContactLabel> result = new ArrayList<IContactLabel>();
    if (contactLists.containsKey("allianceContactLabels")) result.addAll(contactLists.get("allianceContactLabels"));
    return result;
  }

}