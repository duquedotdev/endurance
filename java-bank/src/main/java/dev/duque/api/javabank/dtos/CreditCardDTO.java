package dev.duque.api.javabank.dtos;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class CreditCardDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String acquirer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcquirer() {
        return acquirer;
    }

    public void setAcquirer(String acquirer) {
        this.acquirer = acquirer;
    }

}
