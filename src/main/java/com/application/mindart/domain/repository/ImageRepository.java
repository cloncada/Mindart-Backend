package com.application.Mindart.repository;
import com.application.Mindart.entity.ImageModel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository <ImageModel, Long>{
    Optional<ImageModel> findByName(String name);
}