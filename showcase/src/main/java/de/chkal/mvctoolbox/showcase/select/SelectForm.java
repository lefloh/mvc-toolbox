package de.chkal.mvctoolbox.showcase.select;

import javax.ws.rs.FormParam;

public class SelectForm {

  @FormParam("country")
  private String country;

  @FormParam("pageSize")
  private Integer pageSize;

  @FormParam("intensity")
  private Intensity intensity;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Intensity getIntensity() {
    return intensity;
  }

  public void setIntensity(Intensity intensity) {
    this.intensity = intensity;
  }
}
