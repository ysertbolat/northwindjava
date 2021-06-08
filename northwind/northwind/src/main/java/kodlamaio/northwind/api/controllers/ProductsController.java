package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

//controller birbirinden farklı programlama uygulamalarında ortak şekilde hareket etmesini sağlar
@RestController
//api/product istenirse bu controller çağıralacak
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired //Autowired projeyi tarar ve enjekte işlemlerini yapar
    public ProductsController(ProductService productService){
        super();
        this.productService = productService;
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add") //PostMapping bir data vb. şeyler göndermeye yarar
    public Result add(@RequestBody Product product){ //RequestBody: json'daki data kategorilerini yollar
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){ //RequestParam parametre atama işlemi
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategoryId")
    DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameOrCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>>  getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
}
