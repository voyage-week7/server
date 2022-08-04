package com.example.catchtable.dto;

import com.example.catchtable.model.StoreImageURL;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StoreImageDto {
    private String imagePath;

    public StoreImageDto(StoreImageURL storeImageURL) {
        this.imagePath = storeImageURL.getImagePath();
    }
}
