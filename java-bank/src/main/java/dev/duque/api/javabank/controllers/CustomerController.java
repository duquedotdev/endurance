package dev.duque.api.javabank.controllers;

import dev.duque.api.javabank.dtos.CustomerDTO;
import dev.duque.api.javabank.model.CustomerModel;
import dev.duque.api.javabank.services.CustomerService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Api(value = "CustomerController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/customer")
public class CustomerController {

    final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerDTO customerDTO){
        CustomerModel customerModel = new CustomerModel();

        BeanUtils.copyProperties(customerDTO, customerModel);
        customerModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        customerModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.save(customerModel));
    }

}
