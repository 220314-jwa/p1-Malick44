package net.revature.trmsapp.services;

import net.revature.trmsapp.models.ReimbursementRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestServiceImp implements RequestService{
    @Override
    public List<ReimbursementRequest> findByStatus(int id) {
        return null;
    }

    @Override
    public ReimbursementRequest approve() {
        return null;
    }

    @Override
    public List<ReimbursementRequest> findByEmployeeId(int employeeId) {
        return null;
    }

    @Override
    public ReimbursementRequest submit(ReimbursementRequest request) {
        return null;
    }
}
