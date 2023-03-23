package com.example.atm.data.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="banks")
@Getter
@Setter
@NoArgsConstructor

public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String email;
    private String phone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankEntity)) return false;
        BankEntity that = (BankEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BankEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
