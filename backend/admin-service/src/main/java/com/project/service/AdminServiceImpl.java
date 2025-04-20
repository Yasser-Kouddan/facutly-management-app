package com.project.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.AdminDAO;
import com.project.dto.AdminDTO;
import com.project.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Override
    public AdminDTO addAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        BeanUtils.copyProperties(adminDTO, admin);
        Admin savedAdmin = adminDAO.save(admin);
        AdminDTO savedAdminDTO = new AdminDTO();
        BeanUtils.copyProperties(savedAdmin, savedAdminDTO);
        return savedAdminDTO;
    }

    @Override
    public AdminDTO getAdminById(long id) {
        Admin admin = adminDAO.findById(id).orElse(null);
        AdminDTO adminDTO = new AdminDTO();
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }

    public AdminDTO findAdminByUsernameAndPassword(String username, String password) {
        Admin admin = adminDAO.findAdminByUsernameAndPassword(username, password);
        AdminDTO adminDTO = new AdminDTO();
        BeanUtils.copyProperties(admin, adminDTO);
        return adminDTO;
    }
    @Override
    public AdminDTO login(String username, String password) {
        AdminDTO adminDTO = findAdminByUsernameAndPassword(username, password);
        
        if (adminDTO != null) {
            // L'administrateur est authentifié avec succès
            return adminDTO;
        } else {
            // Si l'authentification échoue, vous pouvez renvoyer null ou lever une exception, selon votre choix de gestion des erreurs.
            return null;
        }
        
    }
 


}
