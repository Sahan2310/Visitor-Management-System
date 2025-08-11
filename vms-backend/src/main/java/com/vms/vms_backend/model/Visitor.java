package com.vms.vms_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visitors")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] image;

    private String fullName;
    private String email;
    private String phone;
    private String purpose;
    private String company;         // ✅ Ensure this field exists
    private String visitorType; 

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    // Constructors
    public Visitor() {}

    public Visitor(String fullName, String email, String phone, String purpose) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.purpose = purpose;
        this.checkIn = LocalDateTime.now();
    }

    // Getters and Setters

    public Long getId() { return id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public LocalDateTime getCheckIn() { return checkIn; }
    public void setCheckIn(LocalDateTime checkIn) { this.checkIn = checkIn; }

    public LocalDateTime getCheckOut() { return checkOut; }
    public void setCheckOut(LocalDateTime checkOut) { this.checkOut = checkOut; }
    // ✅ Getters
    public String getCompany() {
        return company;
    }

    public String getVisitorType() {
        return visitorType;
    }
    public byte[] getImage() { return image; }
public void setImage(byte[] image) { this.image = image; }

public void setVisitorType(String visitorType) {
    this.visitorType = visitorType;
}
public void setCompany(String company) {
    this.company = company;
}
}