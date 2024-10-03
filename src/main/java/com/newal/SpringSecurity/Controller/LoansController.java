package com.newal.SpringSecurity.Controller;

import com.newal.SpringSecurity.Repo.LoanRepo;
import com.newal.SpringSecurity.model.Loans;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepo loanRepo;

    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> myLoansDetails(@RequestParam long id) {
        List<Loans>loans=loanRepo.findByCustomerId(id);

        if(loans!=null){
            return loans;
        }
        else{
            return null;
        }
    }
}
