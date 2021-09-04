package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Relaccion de la interfaz de Producto y  segundo parametro Integer es referencia a la llave primaria
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {//La Entity (Tabla), tipo de llave primaria
    //Ejecuta un Query nativo
    //Signo de interrogacion es pasar un parametro
    /*
    @Query(value = "SELECT * FROM productos where id_categoria=?",nativeQuery = true)
    List<Producto> findByCategory(Integer idCategoria);
*/
    //Lista de productos
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria);//QueryMethods
    /*Es un dato que pueden venir lleno*/
    //Productos escasos
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);




}
