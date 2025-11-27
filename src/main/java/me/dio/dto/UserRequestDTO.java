package me.dio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.dio.domain.model.Account;
import me.dio.domain.model.Card;
import me.dio.domain.model.Feature;
import me.dio.domain.model.News;

import java.util.List;

@Schema(description = "DTO para criação de usuário")
public class UserRequestDTO {

    @Schema(description = "Nome do usuário", example = "João Silva", required = true)
    @NotBlank(message = "Name is required")
    private String name;

    @Schema(description = "Conta do usuário", required = true)
    @NotNull(message = "Account is required")
    @Valid
    private Account account;

    @Schema(description = "Cartão do usuário")
    @Valid
    private Card card;

    @Schema(description = "Lista de funcionalidades")
    @Valid
    private List<Feature> features;

    @Schema(description = "Lista de notícias")
    @Valid
    private List<News> news;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}

