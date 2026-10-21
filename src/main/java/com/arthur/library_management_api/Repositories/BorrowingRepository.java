package com.arthur.library_management_api.Repositories;

import com.arthur.library_management_api.Entities.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

}
