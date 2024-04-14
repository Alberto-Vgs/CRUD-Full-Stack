package vgs.alberto.product.service.impl;

import org.springframework.stereotype.Service;
import vgs.alberto.product.entity.Product;
import vgs.alberto.product.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product saveDepartment(Product department) {
        return null;
    }

    @Override
    public List<Product> fetchDepartmentList() {
        return List.of();
    }

    @Override
    public Product updateDepartment(Product department, Long departmentId) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {

    }
}
