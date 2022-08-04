package com.example.catchtable.controller;

import com.example.catchtable.dto.RestApi;
import com.example.catchtable.dto.StoreImageDto;
import com.example.catchtable.dto.store.StoreRequestDto;
import com.example.catchtable.dto.store.StoreResponseDto;
import com.example.catchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

//     가게 상세 조회
    @GetMapping("/api/stores/{id}")
    public StoreResponseDto getStore(@PathVariable Long id) {
       return storeService.getStore(id);
    }

    // 담당
    // 가게 전체 조회
    @GetMapping("/api/stores")
    public List<StoreResponseDto> getStores(
            @RequestParam @Nullable String filter,
            @RequestParam @Nullable String sort,
            @RequestParam @Nullable String word,
            @RequestParam @Nullable String minPrice,
            @RequestParam @Nullable String maxPrice
            ) {
        return storeService.getStores(filter,sort,word,minPrice,maxPrice);
    }

    // 가게 등록
    @PostMapping("/api/stores/register")
    public RestApi registerStore(@RequestBody StoreRequestDto storeRequestDto) {
        return storeService.registerStore(storeRequestDto);
    }

    // 가게 이미지 등록
    @PostMapping("/api/stores/{id}/images")
    public RestApi postStoreImageURL(@RequestBody StoreImageDto storeImageDto, @PathVariable Long id) {
        return storeService.createStoreImageURL(storeImageDto,id);
    }
}
