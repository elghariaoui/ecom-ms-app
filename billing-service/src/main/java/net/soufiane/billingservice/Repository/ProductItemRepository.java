package net.soufiane.billingservice.Repository;

import net.soufiane.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    List<ProductItem> findByBillId(Long productId);
}
