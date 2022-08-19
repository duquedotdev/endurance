package dev.duque.api.javabank.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_CREDIT_CARD")
public class CreditCardModel {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 50)
    private String name;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String acquirer;
    @Column(nullable = false)
    private Short expirationMounth;
    @Column(nullable = false)
    private Short expirationYear;
    @Column(nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
    @Column(nullable = true)
    private LocalDateTime deletedAt;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

}
