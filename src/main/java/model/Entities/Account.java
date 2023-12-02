package model.Entities.impl;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private User owner;
    private final String register;
    private Double balance = 0.0;
    
    public Account(Integer id, User owner, String register, Double balance) {
        this.id = id;
        this.owner = owner;
        this.register = register;
        this.balance = balance;
    }
}
