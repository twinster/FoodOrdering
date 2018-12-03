package com.development.ordering.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="order_details")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String order_text;
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "confirmer_id", nullable = false)
    private User confirmer;

    public OrderDetails() {}

    public OrderDetails(String order_text, Date updated_at) {
        this.order_text = order_text;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrder_text() {
        return order_text;
    }

    public void setOrder_text(String order_text) {
        this.order_text = order_text;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
