package model.Entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Random;

public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long ownerId;
    private final String register;
    private Double balance = 0.0;

    public Account(Integer id, User owner) {
        this.id = id;
        this.ownerId = owner.getId();
        this.register = generateRegister();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getRegister() {
        return register;
    }

    public Double getBalance() {
        return balance;
    }

    public void withdraw(Double value){}

    public void deposit(Double value){}

    private String generateRegister(){
        StringBuilder register = new StringBuilder();
        String str = "0123456789";
        int length = str.length();
        Random random = new Random();

        for(int i=0;i<length;i++){
            int index = random.nextInt(length);
            register.append(str.charAt(index));

        }

        return register.toString();
    }

}
