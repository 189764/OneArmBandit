package shared.packet;

import java.io.Serializable;
import java.util.ArrayList;

public class Data extends Package implements Serializable {

  /**
   * generated UID
   */
  private static final long serialVersionUID = -8032093128200573185L;

  private String login;
  private String password;
  private boolean isAdmin;
  private Instruction instruction;
  private Integer points;
  private Object[][] ranking;
  

  private ArrayList<Integer> listOfSymbolValues;

  public Data(String login, String password, Instruction instruction) {
    this.login = login;
    this.password = password;
    this.instruction = instruction;
  }

  public Data() {

  }

  public ArrayList<Integer> getListOfSymbolValues() {
    return listOfSymbolValues;
  }

  public void setListOfSymbolValues(ArrayList<Integer> listOfSymbolValues) {
    this.listOfSymbolValues = listOfSymbolValues;
  }

  public Integer getPoints() {
    return this.points;
  }

  public void setPoints(Integer points) {
    this.points = points;
  }

  public Object[][] getRanking() {
    return this.ranking;
  }

  public void setRanking(Object[][] ranking) {
    this.ranking = ranking;
  }

  public boolean getIsAdmin() {
    return this.isAdmin;
  }

  public void setIsAdmin(boolean isAdmin) {
    this.isAdmin = isAdmin;
  }

  public String getLogin() {
    return this.login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Instruction getInstruction() {
    return this.instruction;
  }

  public void setInstruction(Instruction instruction) {
    this.instruction = instruction;
  }

}
