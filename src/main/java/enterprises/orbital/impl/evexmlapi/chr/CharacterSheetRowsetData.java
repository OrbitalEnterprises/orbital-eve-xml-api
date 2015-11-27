package enterprises.orbital.impl.evexmlapi.chr;

/**
 * Generic bean for holding the row contents of a skill, certificate, role or title.
 */
public class CharacterSheetRowsetData {

  // Skill attributes
  private int     typeID;
  private int     level;
  private int     skillpoints;
  private boolean published;

  // Certification attributes
  private int     certificateID;

  // Role attributes
  private long    roleID;
  private String  roleName;

  // Title attributes
  private long    titleID;
  private String  titleName;

  // Jump Clone attributes
  private int     jumpCloneID;
  // typeID overloaded with skill attributes
  private long    locationID;
  private String  cloneName;

  // Jump Clone Implants attributes
  // jumpCloneID overloaded with Jump Clone attributes
  // typeID overloaded with skill attributes
  private String  typeName;

  // Implant attributes
  // typeID overloaded with skill attributes
  // typeName overloaded with Jump Clone Implants attributes

  public int getTypeID() {
    return typeID;
  }

  public int getJumpCloneID() {
    return jumpCloneID;
  }

  public void setJumpCloneID(int jumpCloneID) {
    this.jumpCloneID = jumpCloneID;
  }

  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(long locationID) {
    this.locationID = locationID;
  }

  public String getCloneName() {
    return cloneName;
  }

  public void setCloneName(String cloneName) {
    this.cloneName = cloneName;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getSkillpoints() {
    return skillpoints;
  }

  public void setSkillpoints(int skillpoints) {
    this.skillpoints = skillpoints;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  public int getCertificateID() {
    return certificateID;
  }

  public void setCertificateID(int certificateID) {
    this.certificateID = certificateID;
  }

  public long getRoleID() {
    return roleID;
  }

  public void setRoleID(long roleID) {
    this.roleID = roleID;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public long getTitleID() {
    return titleID;
  }

  public void setTitleID(long titleID) {
    this.titleID = titleID;
  }

  public String getTitleName() {
    return titleName;
  }

  public void setTitleName(String titleName) {
    this.titleName = titleName;
  }

}
