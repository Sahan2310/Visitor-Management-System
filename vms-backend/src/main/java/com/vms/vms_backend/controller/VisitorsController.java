package com.vms.vms_backend.controller;

import com.vms.vms_backend.model.Visitor;
import com.vms.vms_backend.repository.VisitorRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.vms.vms_backend.service.VisitorService;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend access
public class VisitorsController {

    private final VisitorRepository visitorRepository;

    public VisitorsController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    // GET: /api/dashboard/company-counts
    @GetMapping("/company-counts")
    public Map<String, Long> getVisitorsByCompany() {
        List<Visitor> visitors = visitorRepository.findAll();
        return visitors.stream()
                .collect(Collectors.groupingBy(Visitor::getCompany, Collectors.counting()));
    }

    // GET: /api/dashboard/type-counts
    @GetMapping("/type-counts")
    public Map<String, Long> getVisitorsByType() {
        List<Visitor> visitors = visitorRepository.findAll();
        return visitors.stream()
                .collect(Collectors.groupingBy(Visitor::getVisitorType, Collectors.counting()));
    }

    // GET: /api/dashboard/visitors
    @GetMapping("/visitors")
    public List<Visitor> getAllVisitors() {
        return visitorRepository.findAll();
    }
    @RestController
@RequestMapping("/api")
public class VisitorController {

    private final VisitorService visitorService;

    public VisitorController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @GetMapping("/visitors")
    public List<Visitor> getVisitors() {
        return visitorService.getAllVisitors();
    }
}

    // POST: /api/dashboard/visitors
    @PostMapping(value = "/visitors", consumes = {"multipart/form-data"})
public Visitor addVisitor(
    @RequestParam("name") String name,
    @RequestParam("email") String email,
    @RequestParam("phone") String phone,
    @RequestParam("visitorType") String visitorType,
    @RequestParam("company") String company,
    @RequestParam("purpose") String purpose,
    @RequestParam(value = "image", required = false) MultipartFile image
) throws IOException {
    Visitor visitor = new Visitor();
    visitor.setFullName(name);
    visitor.setEmail(email);
    visitor.setPhone(phone);
    visitor.setVisitorType(visitorType);
    visitor.setCompany(company);
    visitor.setPurpose(purpose);
    if (image != null && !image.isEmpty()) {
        visitor.setImage(image.getBytes());
    }
    return visitorRepository.save(visitor);
}
}
