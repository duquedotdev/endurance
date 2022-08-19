package dev.duque.api.javabank.dtos;

import javax.validation.constraints.NotBlank;

public class CustomerDTO {
    @NotBlank
    private String name;


    private Long income;


    private Long personalLimit;


    private Long balance;

    private Boolean isActive;

    private Boolean isVerified;

    private Boolean isDefaulting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Long getPersonalLimit() {
        return personalLimit;
    }

    public void setPersonalLimit(Long personalLimit) {
        this.personalLimit = personalLimit;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public Boolean getDefaulting() {
        return isDefaulting;
    }

    public void setDefaulting(Boolean defaulting) {
        isDefaulting = defaulting;
    }

}
