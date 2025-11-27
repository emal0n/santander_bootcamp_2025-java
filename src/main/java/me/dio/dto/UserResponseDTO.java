package me.dio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import me.dio.domain.model.Account;
import me.dio.domain.model.Card;
import me.dio.domain.model.Feature;
import me.dio.domain.model.News;

import java.util.List;

@Schema(description = "DTO para resposta de usuário")
public class UserResponseDTO {

    @Schema(description = "ID do usuário", example = "1")
    private Long id;

    @Schema(description = "Nome do usuário", example = "João Silva")
    private String name;

    @Schema(description = "Conta do usuário")
    private Account account;

    @Schema(description = "Cartão do usuário")
    private Card card;

    @Schema(description = "Lista de funcionalidades")
    private List<Feature> features;

    @Schema(description = "Lista de notícias")
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

