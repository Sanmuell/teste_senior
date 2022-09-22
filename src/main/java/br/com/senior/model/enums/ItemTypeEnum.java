package br.com.senior.model.enums;

public enum ItemTypeEnum {

    P("Produto"),
    S("Serviço");

    public final String description;

    ItemTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
