package dev.duque.api.javabank.dtos;

import javax.validation.constraints.NotBlank;

public class CustomerDTO {
    @NotBlank
    private String name;

    @NotBlank
    private Long income;

    @NotBlank
    private Long limit;

    @NotBlank
    private Long balance;

    @NotBlank
    private Boolean isActive;

    @NotBlank
    private Boolean isVerified;

    @NotBlank
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

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
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
