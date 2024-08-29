package com.scm.entities;


import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Contact {
    @Id
    public String id;
    public String name;
   public String email;
   public String phoneNmuber;
    public String address;
    public String picture;
    public String description;
    public boolean favorite=false;
    private String websitelink;
    private String linkedInLink;


//private List<String> socialLinks= new ArrayList<>();
@ManyToOne
private User user;

 @OneToMany(mappedBy = "contact", cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> links = new ArrayList<>();

}