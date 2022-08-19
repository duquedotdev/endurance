package dev.duque.api.javabank.controllers;

import dev.duque.api.javabank.dtos.CreditCardDTO;
import dev.duque.api.javabank.model.CreditCardModel;
import dev.duque.api.javabank.repositories.CustomerRepository;
import dev.duque.api.javabank.services.CreditCardService;
import dev.duque.api.javabank.services.CustomerService;
import dev.duque.api.javabank.utils.CreditCardNumberGenerator;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

@Api(value = "CreditCardController")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/credit-card")
public class CreditCardController {

    final CreditCardService creditCardService;
    final CustomerService customerService;

    public CreditCardController(CreditCardService creditCardService, CustomerService customerService) {
        this.creditCardService = creditCardService;
        this.customerService = customerService;
    }

    @PostMapping("/{client-id}")
    public ResponseEntity<Object> createCreditCard(
            @PathVariable(value = "client-id") UUID clientId,
            @RequestBody @Valid CreditCardDTO creditCardDTO) {
        CreditCardModel creditCardModel = new CreditCardModel();

        if(customerService.findByIdWithLock(clientId).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }

        BeanUtils.copyProperties(creditCardDTO, creditCardModel);

        CreditCardNumberGenerator creditCardNumberGenerator = new CreditCardNumberGenerator();
        creditCardModel.setNumber(creditCardNumberGenerator.generate());
        creditCardModel.setExpirationMounth(LocalDateTime.now().getMonthValue());
        creditCardModel.setExpirationYear(LocalDateTime.now().getYear() + 10);
        creditCardModel.setActive(true);
        creditCardModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        creditCardModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.CREATED).body(creditCardService.save(creditCardModel));
    }




}
