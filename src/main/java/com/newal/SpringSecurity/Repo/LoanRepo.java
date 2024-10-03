package com.newal.SpringSecurity.Repo;

import com.newal.SpringSecurity.model.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepo extends CrudRepository<Loans,Long> {

    @PreAuthorize("hasRole('USER')")
    List<Loans> findByCustomerId(long customerId);
}
