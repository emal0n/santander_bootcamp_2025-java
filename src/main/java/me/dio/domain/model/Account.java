package me.dio.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity(name = "tb_account")
@Schema(description = "Modelo de conta bancária")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da conta", example = "1")
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Account number is required")
    @Schema(description = "Número da conta", example = "12345-6", required = true)
    private String number;

    @NotBlank(message = "Agency is required")
    @Schema(description = "Agência", example = "0001", required = true)
    private String agency;

    @Column(precision = 13, scale = 2)
    @NotNull(message = "Balance is required")
    @PositiveOrZero(message = "Balance must be positive or zero")
    @Schema(description = "Saldo da conta", example = "1000.00", required = true)
    private BigDecimal balance;

    @Column(name = "additional_limit", precision = 13, scale = 2)
    @NotNull(message = "Limit is required")
    @PositiveOrZero(message = "Limit must be positive or zero")
    @Schema(description = "Limite adicional", example = "500.00", required = true)
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
