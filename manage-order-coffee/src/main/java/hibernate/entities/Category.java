package hibernate.entities;



import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "loai")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Loai")
    private int id;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Product> product;
    @Column(name = "name")
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
