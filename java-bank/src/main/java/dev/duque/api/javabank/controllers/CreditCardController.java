package dev.duque.api.javabank.controllers;

import dev.duque.api.javabank.dtos.CreditCardDTO;
import dev.duque.api.javabank.model.CreditCardModel;
import dev.duque.api.javabank.services.CreditCardService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Api(value = "ParkingSpotController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public ResponseEntity<Object> createCreditCard(@RequestBody @Valid CreditCardDTO creditCardDTO) {
        CreditCardModel creditCardModel = new CreditCardModel();

        //Inserir método que cria numeração do cartão baseado na bandeira

        BeanUtils.copyProperties(creditCardDTO, creditCardModel);
        creditCardModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardService.save(creditCardModel));
    }

//    @GetMapping("/{credit-card}")
//    public ResponseEntity<Object> validateCreditCard(@PathVariable(value = "creditCard") Long number){
//
//    }


}
