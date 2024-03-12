package com.bootcamp.ejercicio_empleados_elastic.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "emp1")
@Data
@AllArgsConstructor
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private Integer edad;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Direccion direccion;
}
