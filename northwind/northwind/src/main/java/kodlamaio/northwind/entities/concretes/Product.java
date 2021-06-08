package kodlamaio.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="products") //table rotasyonu
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Id'nin nasıl oluşacağı
    @Column(name="product_id") //hangi kolona denk geleceği
    private int id;

    //category_id'yi ilişkilendirdiğimiz için ekstraya gerek yok
    //@Column(name="category_id")
    //private int categoryId;

    @Column(name="product_name")
    private String productName;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private short unitsInStock;

    @Column(name="quantity_per_unit")
    private String quantityPerUnit;


    @ManyToOne() //ilişkisi olan data ile ilişki kurma işlemi
    @JoinColumn(name = "category_id")
    private Category category;

}
