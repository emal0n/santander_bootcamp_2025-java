package me.dio.domain.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity(name = "tb_card")
@Schema(description = "Modelo de cartão")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do cartão", example = "1")
    private Long id;

    @Column(unique = true)
    @NotBlank(message = "Card number is required")
    @Schema(description = "Número do cartão", example = "1234 5678 9012 3456", required = true)
    private String number;

    @Column(name = "available_limit", precision = 13, scale = 2)
    @NotNull(message = "Limit is required")
    @PositiveOrZero(message = "Limit must be positive or zero")
    @Schema(description = "Limite disponível", example = "2000.00", required = true)
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

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }

}
