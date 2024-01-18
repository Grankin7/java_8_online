package ua.com.alevel.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "bank_account")
public class BankAccount extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "amount")
    private Long sum;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
    //    @OneToMany(mappedBy = "account1", cascade =  CascadeType.REMOVE)
//    private Set<Operation> outgoingOperations;
//
//    @OneToMany(mappedBy = "account2", cascade = CascadeType.REMOVE)
//    private Set<Operation> incomingOperations;
//
//    public Account() {
//        this.outgoingOperations = new HashSet<>();
//        this.incomingOperations = new HashSet<>();
//    }

}
