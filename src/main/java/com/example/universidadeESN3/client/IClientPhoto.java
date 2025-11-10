package com.example.universidadeESN3.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "photo-consumer", url = "https://jsonplaceholder.typicode.com/")
public interface IClientPhoto {

    @GetMapping("/photos/{id}")
    Object getPhotoById(@PathVariable Long id);

}
