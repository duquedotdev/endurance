package dev.duque.api.javabank.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CreditCardDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String acquirer;
    @NotBlank
    @Size(min = 1, max = 2)
    private Short expirationMounth;
    @NotBlank
    @Size(min = 4, max = 4)
    private Short expirationYear;
    @NotBlank
    private Boolean isActive;

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

    public Short getExpirationMounth() {
        return expirationMounth;
    }

    public void setExpirationMounth(Short expirationMounth) {
        this.expirationMounth = expirationMounth;
    }

    public Short getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Short expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
