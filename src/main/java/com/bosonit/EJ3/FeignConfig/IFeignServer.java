package com.bosonit.EJ3.FeignConfig;


import com.bosonit.EJ3.Teacher.infraestructure.DTOs.OutputTeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient(name="simpleFeign", url="http://localhost:8080/")
public interface IFeignServer {

    //funciones a las que quiero llamar
    @GetMapping("/person/profesor/{id}")
    ResponseEntity<OutputTeacherDTO> callServer(@PathVariable String id);
}
