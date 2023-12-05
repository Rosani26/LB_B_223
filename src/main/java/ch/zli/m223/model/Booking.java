package ch.zli.m223.model;

import java.sql.Date;
import java.time.Period;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.locationtech.jts.geom.Location;

import com.fasterxml.jackson.annotation.JsonIgnore;

import antlr.collections.List;

@Entity
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private Date date;

  @Enumerated(EnumType.STRING)
  private Period period;

  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "location_id", nullable = false)
  private Location location;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "applicationUser_id", nullable = false)
  private ApplicationUser applicationUser;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public Date setDate(Date date) {
    return this.date = date;
  }

   public Period getPeriod() {
    return period;
  }

  public Period setPeriod(Period period) {
    return this.period = period;
  }


  public Status getstatus() {
    return status;
  }

  public Status setstatus(Status status) {
    return this.status = status;
  }

  public Location getLocation() {
    return location;
  }

  public Location setLocation(Location location) {
    return this.location = new Location();
  }

  public ApplicationUser getApplicatonUser() {
    return applicationUser;
  }

  public ApplicationUser setApplicationUser(ApplicationUser applicationUser) {
    return this.applicationUser = new ApplicationUser();
  }

}
