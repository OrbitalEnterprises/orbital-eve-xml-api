package enterprises.orbital.evexmlapi.shared;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContactSet.class)
public interface IContactSet {

  /**
   * Retrieve list of character contacts. This list will be empty for corporation accounts.
   * 
   * @return the list of character contacts.
   */
  public List<IContact> getContacts();

  public List<IContact> getCorporateContacts();

  public List<IContact> getAllianceContacts();

  /**
   * Retrieve list of character contact labels. This list will be empty for corporation accounts.
   * 
   * @return the list of character contact labels.
   */
  public List<IContactLabel> getContactLabels();

  public List<IContactLabel> getCorporateContactLabels();

  public List<IContactLabel> getAllianceContactLabels();
}
