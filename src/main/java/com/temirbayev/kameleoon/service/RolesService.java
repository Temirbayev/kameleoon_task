package com.temirbayev.kameleoon.service;

import com.temirbayev.kameleoon.model.Roles;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RolesService {
    Roles createRole(Roles roles);
}
