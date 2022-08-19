package dev.duque.api.javabank.model;

import org.springframework.data.jpa.repository.Lock;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Column(nullable = false)
    private Long income;
    @Column(nullable = false)
    private Long limit;
    @Column(nullable = false)
    private Long balance;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isVerified;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDefaulting;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @ManyToOne
    public CreditCardModel creditCard;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public CreditCardModel getCreditcard() {
        return creditCard;
    }

    public void setCreditcard(CreditCardModel creditCard) {
        this.creditCard = creditCard;
    }


}
