package com.example.fitjourney.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    @Column(unique = true, nullable = false)
    private String email; 
    
    @Column(nullable = false)
    private String password;

    private boolean enabled = true;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Profile profile;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
    
}
