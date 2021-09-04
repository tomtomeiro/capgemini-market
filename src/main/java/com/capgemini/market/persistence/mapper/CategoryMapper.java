package com.capgemini.market.persistence.mapper;


import com.capgemini.market.domain.Category;
import com.capgemini.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //lista de mapeos
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")

    })

    //convertiremos a categoria a Category
    //Ayuda aproteger los nombres de campos
    Category toCategory(Categoria categoria);
    /*Mapeo a la inversa */
    @InheritInverseConfiguration
    //Ingnore el id del producto
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
