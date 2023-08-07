package com.softeer.caart.domain.composition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softeer.caart.domain.composition.wd.WheelDrive;

public interface WheelDriveRepository extends JpaRepository<WheelDrive, Long> {

}
