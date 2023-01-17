package com.matching.controller;


import com.matching.service.ClientService;
import com.matching.service.SellerService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    private final SellerService sellerService;

    //내 프로필 설정
    @PostMapping("/client")
    //프로필 만드는 로직은 유저에 있다. 유저에서 가져와서 만든다.
    public ResponseEntity<>
//    public UserService updateProfile(@RequestBody UserRequestDto requestDto) {
//        return
//    }

    //내 프로필 조회
    @GetMapping("/client")

    //전체 판매 상품 조회
    @GetMapping("/client/products")
    public ResponseEntity<List<>> getAllProducts(){
        List<> = clientService.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body();
    }


    //전체 판매자 목록 조회
    @GetMapping("/client/sellers")
    public ResponseEntity<List<SellerResponseDto>> getAllSellers(){
        List<SellerResponseDto> sellerResponseDtos = sellerService.getAllSellers();
        return ResponseEntity.status(HttpStatus.OK).body(sellerResponseDtos);

    }

    //판매자 선택 조회
    @GetMapping("/client/seller/{id}")
    public ResponseEntity<SellerResponseDto> getSellerInfo(@PathVariable Long id){
        SellerResponseDto sellerResponseDto = sellerService.getSellerInfo(id);
        return ResponseEntity.status(HttpStatus.OK).body(sellerResponseDto);
    }

    //판매자에게 매칭 요청
    @PostMapping("/client/sellers/{id}")

    //판마자 권한 요청
    @PostMapping("/client/seller")
}
