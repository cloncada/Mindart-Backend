package com.application.mindart.domain.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.application.mindart.app.api.AdminApi;
import com.application.mindart.app.request.CreateAdminRequest;
import com.application.mindart.domain.entity.Admin;
import com.application.mindart.domain.entity.Artist;
import com.application.mindart.domain.entity.Company;
import com.application.mindart.domain.repository.AdminRepository;
import com.application.mindart.domain.repository.ArtistRepository;
import com.application.mindart.domain.repository.CompanyRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final ArtistRepository artistRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(AdminRepository adminRepository,
                        ArtistRepository artistRepository,
                        CompanyRepository companyRepository,
                        PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.artistRepository = artistRepository;
        this.companyRepository = companyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Admin saveAdmin(CreateAdminRequest request) throws Exception {
        Admin admin = adminRepository.findByEmail(request.getEmail());
        if (admin != null) {
            throw new Exception("Ya existe un admin con ese correo.");
        }

        Artist artist = artistRepository.findByEmail(request.getEmail());
        if (artist != null) {
            throw new Exception("Ya existe un artista con ese correo.");
        }

        Company company = companyRepository.findByEmail(request.getEmail());
        if (company != null) {
            throw new Exception("Ya existe una empresa con ese correo.");
        }

        Admin adminToSave = new Admin();
        adminToSave.setDob(request.getDob());
        adminToSave.setEmail(request.getEmail());
        adminToSave.setName(request.getName());
        adminToSave.setNumber(request.getNumber());
        adminToSave.setPassword(passwordEncoder.encode(request.getPassword()));

        return adminRepository.save(adminToSave);
    }

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Integer id, String user) throws Exception {

        Admin admin = adminRepository.findById(id).orElseThrow(() -> new Exception("Usuario no existe."));
        if (!user.equals(admin.getEmail())) {
            throw new Exception("Forbidden.");
        }

        return admin;
    }

    public String deleteAdmin(Integer id) {
        adminRepository.deleteById(id);
        return "removed admin with id " + id;
    }

    public Admin updateAdmin(Admin admin) {
        return null;
    }

    public Admin searchEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    public AdminApi getByEmail(String email) throws Exception {
        Admin admin = adminRepository.findByEmail(email);
        if (Objects.isNull(admin)) {
            throw new Exception("Admin not found.");
        }

        AdminApi adminApi = new AdminApi();
        adminApi.setDob(admin.getDob());
        adminApi.setEmail(admin.getEmail());
        adminApi.setName(admin.getName());
        adminApi.setNumber(admin.getNumber());
        return adminApi;
    }

}
