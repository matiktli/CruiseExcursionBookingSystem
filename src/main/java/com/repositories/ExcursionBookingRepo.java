package com.repositories;

import com.models.ExcursionBookingPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExcursionBookingRepo extends JpaRepository<ExcursionBookingPersistence,Long> {

}
