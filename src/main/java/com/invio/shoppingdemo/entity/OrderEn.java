package com.invio.shoppingdemo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order" , schema = "shopping")
public class OrderEn {

    //Order isminde Spring in kendi dosyalari oldugundan karistirilmamasi icin OrderEn Entity ismi tercih edildi.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL , mappedBy = "orderEn")
    private Basket basket;
}
