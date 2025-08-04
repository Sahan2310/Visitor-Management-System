package com.vms.vms_backend.repository;

import com.vms.vms_backend.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    // You can define custom query methods here later
}
