package com.vms.vms_backend.service;

import com.vms.vms_backend.model.Visitor;
import com.vms.vms_backend.repository.VisitorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitorService {

    private final VisitorRepository visitorRepository;

    public VisitorService(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
}
