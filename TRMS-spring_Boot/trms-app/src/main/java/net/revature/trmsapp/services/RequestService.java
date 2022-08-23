package net.revature.trmsapp.services;

import net.revature.trmsapp.models.ReimbursementRequest;

import java.util.List;

public interface RequestService {
    public List<ReimbursementRequest> findByStatus(int id);
    public ReimbursementRequest approve();
    public List<ReimbursementRequest> findByEmployeeId(int employeeId);
    public ReimbursementRequest submit( ReimbursementRequest request);
}
