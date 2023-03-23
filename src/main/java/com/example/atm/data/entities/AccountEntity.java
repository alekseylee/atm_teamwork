package com.example.atm.data.entities;

import com.example.atm.data.AccountStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name ="accounts")
@NoArgsConstructor

public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    private String userName;
    private String accountNumber;
    private AccountStatus status;

    @ManyToOne
    private CustomerEntity owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountEntity)) return false;
        AccountEntity entity = (AccountEntity) o;
        return id.equals(entity.id) && accountNumber.equals(entity.accountNumber) && status == entity.status && owner.equals(entity.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, status, owner);
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", balance=" + balance +
                ", userName='" + userName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", status=" + status +
                ", owner=" + owner +
                '}';
    }
}


