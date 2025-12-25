package net.soufiane.billingservice.Controller;

import net.soufiane.billingservice.Repository.BillRepository;
import net.soufiane.billingservice.Repository.ProductItemRepository;
import net.soufiane.billingservice.entities.Bill;
import net.soufiane.billingservice.feign.CustomerServiceRestClient;
import net.soufiane.billingservice.feign.InventoryServiceRestClient;
import net.soufiane.billingservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerServiceRestClient customerServiceRestClient;
    @Autowired
    private InventoryServiceRestClient inventoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItemList().forEach(pi ->
                pi.setProduct(inventoryServiceRestClient.getProduct(pi.getProductId())));
        return bill;
    }
}
