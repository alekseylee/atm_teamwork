package com.example.atm.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="customers")

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private Character gender;

    @Length(min = 4, max = 6)
    private String pinCode;
    @Email
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerEntity)) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id.equals(that.id) && pinCode.equals(that.pinCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pinCode);
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", pincode='" + pinCode + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
