package kodlamaio.northwind.dataAccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//Crud veritabanı işlemleri(ekleme update silme)
public interface ProductDao extends JpaRepository<Product,Integer> {

    //Bu yazdıklarımız sql'deki select * from gibi dataları getirme işlemidir(hazır kodlardır, veritabanıyla uğraştırmaz)
    Product getByProductName(String productName);

    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

    //category id ile
    List<Product> getByCategoryIn(List<Integer> categories);

    //içeren
    List<Product> getByProductNameContains(String productName);

    //product isminde içerenlerle alakalı
    List<Product> getByProductNameStartsWith(String productName);
    List<Product> getByProductNameEndsWith(String productName);

    //Jpql = Link gibi string formatta yazılan yapıdır. Sorguları ilişkilendirdiğimizde bu sorguyu objeler üzerinden yapar.
    @Query("From Product where productName=:productName and category.categoryId=:categoryId") //=: parametre demek
    List<Product> getByNameAndCategory(String productName, int categoryId);

    //Dto için product ve category'i ilişkilendirdik;
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();
    //SQL karşılığı on koşulu SQL'deki gibi JPQL'de yazılmaz
    //select p.product_id,p.product_name, c.category_name,p.unit_price from products p inner join categories c on p.category_id =c.category_id


}
