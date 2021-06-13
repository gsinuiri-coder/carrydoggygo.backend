package com.gyasociety.carrydoggygoservice.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="walking_sessions")
public class WalkingSession extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Short hours;

    private Double price;

    private Date dateSession;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dog_walker_id", nullable = false)
    @JsonIgnore
    private DogWalker dogWalker;

    @Transient
    private Long dogWalkerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_type_id", nullable = false)
    @JsonIgnore
    private PaymentType paymentType;

    @Transient
    private Long paymentTypeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification_id")
    @JsonIgnore
    private Qualification qualification;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "walking_session_dogs",
            joinColumns = {@JoinColumn(name = "walking_session_id")},
            inverseJoinColumns = {@JoinColumn(name = "dog_id")})
    @JsonIgnore
    private List<Dog> dogs;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "walking_session_locations",
            joinColumns = {@JoinColumn(name = "walking_session_id")},
            inverseJoinColumns = {@JoinColumn(name = "location_id")})
    @JsonIgnore
    private List<Location> locations;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "walking_session_walk_status",
            joinColumns = {@JoinColumn(name = "walking_session_id")},
            inverseJoinColumns = {@JoinColumn(name = "walk_status_id")})
    @JsonIgnore
    private List<WalkStatus> walkStatus;

    //    --------------------------------------------
    public boolean isDogAssignedWith(Dog dog) {
        return (this.getDogs().contains(dog));
    }

    public WalkingSession assignDogWith(Dog dog) {
        if(!this.isDogAssignedWith(dog)) {
            this.getDogs().add(dog);
        }
        return this;
    }

    public WalkingSession unAssignDogWith(Dog dog) {
        if(this.isDogAssignedWith(dog)) {
            this.getDogs().remove(dog);
        }
        return this;
    }
    //    --------------------------------------------

    //    --------------------------------------------
    public boolean isLocationAssignedWith(Location location) {
        return (this.getLocations().contains(location));
    }

    public WalkingSession assignLocationWith(Location location) {
        if(!this.isLocationAssignedWith(location)) {
            this.getLocations().add(location);
        }
        return this;
    }

    public WalkingSession unAssignLocationWith(Location location) {
        if(this.isLocationAssignedWith(location)) {
            this.getLocations().remove(location);
        }
        return this;
    }
    //    --------------------------------------------

    //    --------------------------------------------
    public boolean isWalkStatusAssignedWith(WalkStatus walkStatus) {
        return (this.getWalkStatus().contains(walkStatus));
    }

    public WalkingSession assignWalkStatusWith(WalkStatus walkStatus) {
        if(!this.isWalkStatusAssignedWith(walkStatus)) {
            this.getWalkStatus().add(walkStatus);
        }
        return this;
    }

    public WalkingSession unAssignWalkStatusWith(WalkStatus walkStatus) {
        if(this.isWalkStatusAssignedWith(walkStatus)) {
            this.getWalkStatus().remove(walkStatus);
        }
        return this;
    }
    //    --------------------------------------------

    public Long getId() {
        return id;
    }

    public WalkingSession setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getHours() {
        return hours;
    }

    public WalkingSession setHours(Short hours) {
        this.hours = hours;
        return this;
    }

    public Double getPrice() {
        return price;
    }

    public WalkingSession setPrice(Double price) {
        this.price = price;
        return this;
    }

    public Date getDateSession() {
        return dateSession;
    }

    public WalkingSession setDateSession(Date dateSession) {
        this.dateSession = dateSession;
        return this;
    }

    public DogWalker getDogWalker() {
        return dogWalker;
    }

    public WalkingSession setDogWalker(DogWalker dogWalker) {
        this.dogWalker = dogWalker;
        return this;
    }

    public Long getDogWalkerId() {
        return dogWalkerId;
    }

    public WalkingSession setDogWalkerId(Long dogWalkerId) {
        this.dogWalkerId = dogWalkerId;
        return this;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public WalkingSession setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
    }

    public Long getPaymentTypeId() {
        return paymentTypeId;
    }

    public WalkingSession setPaymentTypeId(Long paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
        return this;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public WalkingSession setQualification(Qualification qualification) {
        this.qualification = qualification;
        return this;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public WalkingSession setDogs(List<Dog> dogs) {
        this.dogs = dogs;
        return this;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public WalkingSession setLocations(List<Location> locations) {
        this.locations = locations;
        return this;
    }

    public List<WalkStatus> getWalkStatus() {
        return walkStatus;
    }

    public WalkingSession setWalkStatus(List<WalkStatus> walkStatus) {
        this.walkStatus = walkStatus;
        return this;
    }
}
