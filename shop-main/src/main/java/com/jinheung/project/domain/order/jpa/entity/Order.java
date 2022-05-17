package com.jinheung.project.domain.order.jpa.entity;

import com.jinheung.project.domain.order.dto.OrderRequest;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "orders")
@Entity
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id = null;

    @Column(name = "imp_uid")
    private String impUid;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderHasProduct> products;

    @Column
    private String reason;

    @Column
    @Builder.Default
    private Integer success = 0;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public static Order fromDto(String impUid) {
        return Order.builder()
            .impUid(impUid).build();

    }

}
