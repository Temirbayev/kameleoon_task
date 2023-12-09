package com.temirbayev.kameleoon.service.impl;

import com.temirbayev.kameleoon.model.Roles;
import com.temirbayev.kameleoon.repository.RolesRepository;
import com.temirbayev.kameleoon.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.spi.ServiceRegistry;
import java.util.Set;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Roles createRole(Roles roles) {
        return rolesRepository.save(roles);
    }
}
