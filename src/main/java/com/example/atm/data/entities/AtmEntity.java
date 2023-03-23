package com.example.atm.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="atms")
@Getter
@Setter
@NoArgsConstructor
public class AtmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String postcode;
    private String city;
    private String country;
    @ManyToOne
    @JoinColumn(name="bank_id") private BankEntity bank;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtmEntity)) return false;
        AtmEntity atmEntity = (AtmEntity) o;
        return id.equals(atmEntity.id) && bank.equals(atmEntity.bank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bank);
    }

    @Override
    public String toString() {
        return "AtmEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", bank=" + bank +
                '}';
    }
}