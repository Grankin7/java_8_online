package ua.com.alevel.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "operation")
public class Operation extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id_who_transfers")
    private User userWhoTransfers;

    @ManyToOne
    @JoinColumn(name = "user_id_who_gets")
    private User userWhoGets;

    @Column(name = "amount")
    private Long sum;

    public User getUserWhoTransfers() {
        return userWhoTransfers;
    }

    public void setUserWhoTransfers(User userWhoTransfers) {
        this.userWhoTransfers = userWhoTransfers;
    }

    public User getUserWhoGets() {
        return userWhoGets;
    }

    public void setUserWhoGets(User userWhoGets) {
        this.userWhoGets = userWhoGets;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }
}
