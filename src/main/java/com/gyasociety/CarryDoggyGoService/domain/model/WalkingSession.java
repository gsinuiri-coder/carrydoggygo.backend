package com.gyasociety.CarryDoggyGoService.domain.model;

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

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "payment_type_id", nullable = false)
//    @JsonIgnore
//    private PaymentType paymentType;
//
//    @Transient
//    private Long paymentTypeId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
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
    public boolean isDogTaggedWith(Dog tag) {
        return (this.getDogs().contains(tag));
    }

    public WalkingSession dogTagWith(Dog tag) {
        if(!this.isDogTaggedWith(tag)) {
            this.getDogs().add(tag);
        }
        return this;
    }

    public WalkingSession dogUnTagWith(Dog tag) {
        if(this.isDogTaggedWith(tag)) {
            this.getDogs().remove(tag);
        }
        return this;
    }
    //    --------------------------------------------

    //    --------------------------------------------
    public boolean isLocationTaggedWith(Location tag) {
        return (this.getLocations().contains(tag));
    }

    public WalkingSession locationTagWith(Location tag) {
        if(!this.isLocationTaggedWith(tag)) {
            this.getLocations().add(tag);
        }
        return this;
    }

    public WalkingSession locationUnTagWith(Location tag) {
        if(this.isLocationTaggedWith(tag)) {
            this.getLocations().remove(tag);
        }
        return this;
    }
    //    --------------------------------------------

    //    --------------------------------------------
    public boolean isWalkStatusTaggedWith(WalkStatus tag) {
        return (this.getWalkStatus().contains(tag));
    }

    public WalkingSession walkStatusTagWith(WalkStatus tag) {
        if(!this.isWalkStatusTaggedWith(tag)) {
            this.getWalkStatus().add(tag);
        }
        return this;
    }

    public WalkingSession walkStatusUnTagWith(WalkStatus tag) {
        if(this.isWalkStatusTaggedWith(tag)) {
            this.getWalkStatus().remove(tag);
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

    public DogWalker getDogWalker() {
        return dogWalker;
    }

    public WalkingSession setDogWalker(DogWalker dogWalker) {
        this.dogWalker = dogWalker;
        return this;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public WalkingSession setQualification(Qualification qualification) {
        this.qualification = qualification;
        return this;
    }

    public Long getDogWalkerId() {
        return dogWalkerId;
    }

    public WalkingSession setDogWalkerId(Long dogWalkerId) {
        this.dogWalkerId = dogWalkerId;
        return this;
    }


}
