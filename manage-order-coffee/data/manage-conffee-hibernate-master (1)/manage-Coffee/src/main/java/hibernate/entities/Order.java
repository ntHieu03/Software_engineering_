package hibernate.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString()
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoadon")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "total_money")
    private float totalPrice;
    @Column(name = "create_day")
    private Date createdDate;
    @Column(name = "id_NV")
    private int id_Staff;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_KH", nullable = false, foreignKey = @ForeignKey(name = "hoadon_ibfk_1"))
    private Customer customer;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetail;

    @Override
    public String toString() {
        return "Order [id=" + id + orderDetail.toString() + " -- " + customer.toString() + ", totalPrice=" + totalPrice + "]";
    }

}
