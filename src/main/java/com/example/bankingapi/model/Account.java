package com.example.bankingapi.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
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
    private AccountCategory category;

    @Column()
    private AccountStatus status;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime DeletedAt;

    @Column
    @UpdateTimestamp
    private LocalDateTime UpdatedAt;
}
