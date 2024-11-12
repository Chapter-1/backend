package com.chapter1.blueprint.finance.controller;

import com.chapter1.blueprint.exception.dto.SuccessResponse;
import com.chapter1.blueprint.finance.service.FinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/finance")
public class FinanceController {
    private final FinanceService financeService;

    @GetMapping(value = "/update/deposit")
    public ResponseEntity<?> updateDeposit() {
        String result = financeService.updateDeposit();
        return ResponseEntity.ok(new SuccessResponse(result));
    }

    @GetMapping(value = "/update/saving")
    public ResponseEntity<?> updateSaving() {
        String result = financeService.updateSaving();
        return ResponseEntity.ok(new SuccessResponse(result));
    }

    @GetMapping(value = "/update/mortgage")
    public ResponseEntity<?> updateMortgage() {
        String result = financeService.updateMortgageLoan();
        return ResponseEntity.ok(new SuccessResponse(result));
    }

    @GetMapping(value = "/update/rentHouse")
    public ResponseEntity<?> updateRentHouse() {
        String result = financeService.updateRenthouse();
        return ResponseEntity.ok(new SuccessResponse(result));
    }

    @GetMapping("/image/{idx}")
    public ResponseEntity<Map<String, String>> getImageUrl(@PathVariable Long idx) {
        String imageUrl = financeService.getImageUrlByIdx(idx);
        if (imageUrl != null) {
            Map<String, String> response = new HashMap<>();
            response.put("image_url", imageUrl);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
