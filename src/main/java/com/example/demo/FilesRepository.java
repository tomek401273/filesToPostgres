package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<FileModel, Long>{
}
