package com.c4.ud26.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c4.ud26.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Long>{

}
