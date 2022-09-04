package com.example.bankingapi.infrastructure.persistance.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {

    @Id
    @Column
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private Integer balance = 0;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column()
    private  String type;

    @Column()
    private String status = "activated";

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column()
    @Nullable
    private LocalDateTime DeletedAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime UpdatedAt;


    protected Account(){}

    public Account(Integer balance,
                   Boolean isActive,
                   String type
                   ) {
        this.balance = balance;
        this.isActive = isActive;
        this.type = type;

    }
}
