package hibernate.entities;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ct_hoadon")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_HD",nullable = true,foreignKey = @ForeignKey(name = "chitiethoadon_ibfk_1"))
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_SP",nullable = false,foreignKey = @ForeignKey(name = "product_ibfk_2"))
    private Product product;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;
    @Column(name = "price")
    private  float price;

    @Override
    public String toString() {
        return "OrderDetail(id=" + id + " -- " +product.toString() +" -- " +" amount=" + amount + ", price "+price+ ")";
    }


}
