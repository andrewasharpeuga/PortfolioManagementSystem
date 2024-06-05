package com.portfolio.api;

import com.portfolio.investment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @PostMapping("/add")
    public ResponseEntity<String> addInvestment(@RequestBody InvestmentRequest request) {
        Investment investment;
        switch (request.getType().toLowerCase()) {
            case "stock":
                investment = new Stock(request.getName(), request.getAmountInvested(), request.getShares(), request.getCurrentPricePerShare());
                break;
            case "bond":
                investment = new Bond(request.getName(), request.getAmountInvested(), request.getInterestRate(), request.getYears());
                break;
            case "mutualfund":
                investment = new MutualFund(request.getName(), request.getAmountInvested(), request.getNetAssetValue());
                break;
            default:
                return ResponseEntity.badRequest().body("Invalid investment type.");
        }
        investmentService.addInvestment(investment);
        return ResponseEntity.ok("Investment added successfully.");
    }

    @DeleteMapping("/remove/{name}")
    public ResponseEntity<String> removeInvestment(@PathVariable String name) {
        investmentService.getInvestments().stream()
                .filter(inv -> inv.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(investmentService::removeInvestment);
        return ResponseEntity.ok("Investment removed successfully.");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Investment>> getAllInvestments() {
        return ResponseEntity.ok(investmentService.getInvestments());
    }
}

class InvestmentRequest {
    private String type;
    private String name;
    private double amountInvested;
    private int shares;
    private double currentPricePerShare;
    private double interestRate;
    private int years;
    private double netAssetValue;

    // Getters and Setters
}
