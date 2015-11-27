package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.evexmlapi.crp.IMemberSecurityLog;
import enterprises.orbital.evexmlapi.crp.ISecurityRole;

public class ApiRoleHistory implements IMemberSecurityLog {
  private Date                     changeTime;
  private long                     characterID;
  private String                   characterName;
  private long                     issuerID;
  private String                   issuerName;
  private String                   roleLocationType;
  private final Set<ISecurityRole> oldRoles = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole> newRoles = new HashSet<ISecurityRole>();

  @Override
  public Date getChangeTime() {
    return changeTime;
  }

  public void setChangeTime(Date changeTime) {
    this.changeTime = changeTime;
  }

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  @Override
  public long getIssuerID() {
    return issuerID;
  }

  public void setIssuerID(long issuerID) {
    this.issuerID = issuerID;
  }

  @Override
  public String getIssuerName() {
    return issuerName;
  }

  public void setIssuerName(String issuerName) {
    this.issuerName = issuerName;
  }

  @Override
  public String getRoleLocationType() {
    return roleLocationType;
  }

  public void setRoleLocationType(String roleLocationType) {
    this.roleLocationType = roleLocationType;
  }

  public void addSecurityRoleBag(SecurityRoleBag securityRoleBag) {
    String name = securityRoleBag.getName();
    if (name.equals("oldRoles")) {
      oldRoles.addAll(securityRoleBag.getSecurityRoles());
    } else if (name.equals("newRoles")) {
      newRoles.addAll(securityRoleBag.getSecurityRoles());
    }
  }

  @Override
  public Set<ISecurityRole> getOldRoles() {
    return oldRoles;
  }

  @Override
  public Set<ISecurityRole> getNewRoles() {
    return newRoles;
  }
}