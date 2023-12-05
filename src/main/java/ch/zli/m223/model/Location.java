package ch.zli.m223.model;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;

@Entity
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private boolean availabilityMorning;

  @Column(nullable = false)
  private boolean availabilityAfternoon;

  @Column(nullable = false)
  private boolean availabilityAllDay;

   @Column(nullable = false)
  private Date date;

  

  @OneToMany
  @JsonIgnoreProperties("loation")
  @Fetch(FetchMode.JOIN)
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean getAvailabilityMorning() {
    return availabilityMorning;
  }

  public void setAvailabilityMorning(Boolean availabilityMorning) {
    this.availabilityMorning = availabilityMorning;
  }

   public boolean getAvailabilityAfternoon() {
    return availabilityAfternoon;
  }

  public void setAvailabilityAfternoon(Boolean availabilityAfternoon) {
    this.availabilityAfternoon = availabilityAfternoon;
  }
   public boolean getAvailabilityAllDay() {
    return availabilityAllDay;
  }

  public void setAvailabilityAllDay(Boolean availabilityAllDay) {
    this.availabilityAllDay = availabilityAllDay;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


}