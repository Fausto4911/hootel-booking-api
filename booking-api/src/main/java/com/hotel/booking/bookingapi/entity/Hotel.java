package com.hotel.booking.bookingapi.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hotels")
public class Hotel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    @OneToMany(mappedBy = "hotel")
    private Set<Room> rooms;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "countries_id", referencedColumnName = "id")
    private Country country;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hotel{");
        sb.append("id=").append(id);
        sb.append(", hotelName='").append(hotelName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
