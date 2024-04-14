package vgs.alberto.product.service;

import vgs.alberto.product.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveDepartment(Product department);

    List<Product> fetchDepartmentList();

    Product updateDepartment(Product department, Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
