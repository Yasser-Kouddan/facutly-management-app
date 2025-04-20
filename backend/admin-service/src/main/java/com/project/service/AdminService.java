package com.project.service;

import com.project.dto.AdminDTO;

public interface AdminService {
    public AdminDTO addAdmin(AdminDTO admin);
    public AdminDTO getAdminById(long id);
	public AdminDTO findAdminByUsernameAndPassword(String username, String password);
	AdminDTO login(String username, String password);
	

}
