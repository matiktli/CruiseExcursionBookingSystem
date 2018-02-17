package com.repositories;

import com.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking,Long> {


    //Optional<Map<Long,Integer>> mapIdAndTakenSpaces(@Param("id") Long id);
}
