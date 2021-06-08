package kodlamaio.northwind.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Dto: veritabanında istediğimiz alanların gelmesine yardımcı olur
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;
}
