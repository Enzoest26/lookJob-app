package com.jobSearch.webSite.repository;

import com.jobSearch.webSite.model.UserJob;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJobRepository extends JpaRepository<UserJob, Long> {
}
