package com.repositories;

import com.models.ExcursionBookingPersistence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionBookingRepo extends JpaRepository<ExcursionBookingPersistence,Long> {
}
