package net.soufiane.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.soufiane.billingservice.model.Customer;

import java.util.Date;
import java.util.List;

@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Bill {

    @Id @GeneratedValue
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItemList;
    @Transient
    private Customer customer;

}
