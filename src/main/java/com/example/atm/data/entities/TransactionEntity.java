package com.example.atm.data.entities;

import com.example.atm.data.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private Instant start;
    private Instant end;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @ManyToOne
    private AccountEntity receivers;
    @ManyToOne
    private AccountEntity senders;

    @ElementCollection
    List<String> transactions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionEntity)) return false;
        TransactionEntity entity = (TransactionEntity) o;
        return id.equals(entity.id) && amount.equals(entity.amount) && start.equals(entity.start) && receivers.equals(entity.receivers) && senders.equals(entity.senders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, start, receivers, senders);
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", start=" + start +
                ", end=" + end +
                ", transactionType=" + transactionType +
                ", receivers=" + receivers +
                ", senders=" + senders +
                ", transactions=" + transactions +
                '}';
    }
}
