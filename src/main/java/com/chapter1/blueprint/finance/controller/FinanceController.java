package com.chapter1.blueprint.finance.controller;

import com.chapter1.blueprint.exception.dto.SuccessResponse;
import com.chapter1.blueprint.finance.domain.LoanList;
import com.chapter1.blueprint.finance.domain.SavingsList;
import com.chapter1.blueprint.finance.service.FinanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/filter/savings")
    public ResponseEntity<SuccessResponse> getSavingsFilter() {

        SavingsList savingsList = financeService.getSavingsFilter();
        return ResponseEntity.ok(new SuccessResponse(savingsList));
    }

    @GetMapping("/filter/loan")
    public ResponseEntity<SuccessResponse> getLoanFilter() {

        LoanList loanList = financeService.getLoanFilter();
        return ResponseEntity.ok(new SuccessResponse(loanList));
    }
}
