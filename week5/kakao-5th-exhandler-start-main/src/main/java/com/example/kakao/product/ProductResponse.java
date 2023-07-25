package com.example.kakao.product;

import com.example.kakao.product.option.Option;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class ProductResponse {
    @Getter
    @Builder
    public static class FindAllDTO {
        private int id;
        private String productName;
        private String description;
        private String image;
        private int price;

        public FindAllDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.description = product.getDescription();
            this.image = product.getImage();
            this.price = product.getPrice();
        }
    }

    @Getter
    @Builder
    public static class FindByIdDTO {
        int id;
        String productName;
        String description;
        String image;
        int price;
        int starCount; // 0~5
        List<OptionDTO> options;

        public FindByIdDTO(Product product, List<Option> optionsList) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.description = product.getDescription();
            this.image = product.getImage();
            this.price = product.getPrice();
            this.starCount = 5;
            this.options = optionsList.stream().map(OptionDTO::new).collect(Collectors.toList());
        }

        @Getter
        @Builder
        public class OptionDTO {
            int id;
            String optionName;
            int price;

            public OptionDTO(Option option) {
                this.id = option.getId();
                this.optionName = option.getOptionName();
                this.price = option.getPrice();
            }
        }
    }
}
