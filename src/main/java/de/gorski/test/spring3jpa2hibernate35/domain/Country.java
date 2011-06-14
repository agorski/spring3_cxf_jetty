package de.gorski.test.spring3jpa2hibernate35.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "country")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@XmlRootElement(name = "Country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country implements Serializable {

  /**
   * Serial UID.
   */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @XmlElement
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @XmlElement
  private String continent;
  @XmlElement
  private String countryName;
  @XmlElement
  private String countryCode;
  private int area;
  private int population;
  private Date independence;
  private String government;
  private String capital;
  private boolean member_g8;
  private String article;

  public String getContinent() {
    return this.continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getCountryName() {
    return this.countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public int getArea() {
    return this.area;
  }

  public void setArea(int area) {
    this.area = area;
  }

  public int getPopulation() {
    return this.population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  public String getGovernment() {
    return this.government;
  }

  public void setGovernment(String government) {
    this.government = government;
  }

  public String getCapital() {
    return this.capital;
  }

  public void setCapital(String capital) {
    this.capital = capital;
  }

  public boolean isMember_g8() {
    return this.member_g8;
  }

  public void setMember_g8(boolean memberG8) {
    this.member_g8 = memberG8;
  }

  public String getArticle() {
    return this.article;
  }

  public void setArticle(String article) {
    this.article = article;
  }

  public Date getIndependence() {
    return this.independence;
  }

  public void setIndependence(Date independence) {
    this.independence = independence;
  }

  @Override
  public String toString() {
    return "Country [id=" + id + ", countryName=" + countryName + ", area="
        + area + ", article=" + article + ", capital=" + capital
        + ", continent=" + continent + ", countryCode=" + countryCode
        + ", government=" + government + ", independence=" + independence
        + ", member_g8=" + member_g8 + ", population=" + population + "]";
  }

}
