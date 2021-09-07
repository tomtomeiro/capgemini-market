package com.capgemini.market.persistence;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.repository.ProductRepository;
import com.capgemini.market.persistence.crud.ProductoCrudRepository;
import com.capgemini.market.persistence.entity.Producto;
import com.capgemini.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository/*Para especificar que es un componente que Interactua con La BD*/
//@Component/*Es un componente de Spring*/
public class ProductoRepository implements ProductRepository {
    @Autowired // solo sirve con componentes de spring
    /*Esta es la interfaz que creamos de ProductoCrubRepository
    * y manda a llamar*/
    private ProductoCrudRepository productoCrudRepository;
    /*metodo que nos recupere los productos de la base de datos*/

    @Autowired
    private ProductMapper mapper;

    public List<Product> getAll(){
        List<Producto> productos =(List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer categoryId) {
        List<Producto> productos= productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts((productos)));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantify) {
        Optional<List<Producto>> productos= productoCrudRepository.findByCantidadStockLessThanAndEstado(quantify, true);
        return productos.map(prods->mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Integer productId) {

        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //LLamar metodo publico llamado seve
    /*public void save(Producto producto){
        productoCrudRepository.save(producto);
    }
    public  void deleteById(Integer id){
        productoCrudRepository.deleteById(id);
    }*/
    public Long getCountRegister(){
        return productoCrudRepository.count();
    }
    /*named Querys busqueda en tablas */
    /*2 de noviembre de 2021*/
    /*public List<Producto> getByCategoria(Integer idCategoria){
        //Llevar logica de negocio miles de lineas
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/
    public Optional<List<Producto>> getEscasos(Integer cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,  true);
    }

    public Optional<Producto> getProducto(Integer idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    @Override
    public  void delete(Integer idProducto){
         productoCrudRepository.deleteById(idProducto);
    }

    //Actualizar nombre del producto por id
    /*public void saveProducto(String nombre,Integer idProducto){
        productoCrudRepository.saveByNombreSetIdProducto(nombre, idProducto);
    }*/





}
