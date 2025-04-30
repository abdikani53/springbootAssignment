package com.example.springbootexercise.service;


import com.example.springbootexercise.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffService {

    private final Map<Long, Staff> staffMap = new HashMap<>();
    private Long idCounter = 1L;

    public List<Staff> getAllStaffs() {
        return new ArrayList<>(staffMap.values());
    }

    public Staff getStaff(Long id) {
        return staffMap.get(id);
    }

    public Staff createStaff(Staff staff) {
        staff.setId(idCounter++);
        staffMap.put(staff.getId(), staff);
        return staff;
    }

    public Staff updateStaff(Long id, Staff staff) {
        staff.setId(id);
        staffMap.put(id, staff);
        return staff;
    }

    public void deleteStaff(Long id) {
        staffMap.remove(id);
    }
}
