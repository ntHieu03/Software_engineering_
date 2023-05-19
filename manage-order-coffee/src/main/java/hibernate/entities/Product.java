package hibernate.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@ToString()

@Entity
@Table(name = "sanpham")
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_SP")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_Loai",nullable = false,foreignKey = @ForeignKey(name = "sanpham_ibfk_1"))
    private Category category;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "amount",nullable=false)
    private int amount;

    @Column(name = "price")
    private float price;

    @Column(name = "img")
    private String image;

    @OneToMany(mappedBy = "product",fetch=FetchType.EAGER)
    private Set<OrderDetail> OrderDetail;

    public Product(int id, Category category, String name, String description, int amount, float price, String image) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }



    @Override
    public String toString() {
        return "Product(id=" + id +" Category="+ category.getName()+", name=" + name + ", description=" + description+" , price="+price+", img="+image+" )";
    }

}
