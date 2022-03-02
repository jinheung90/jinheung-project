package com.jinheung.project.domain.user.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "user_profiles")
@Entity
@Setter
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long id = null;

    private String nickname;

    @Column(name = "origin_profile_image_url",length = 2047)
    private String originImageUrl;

    @Column(name = "detail_profile_image_url",length = 2047)
    private String detailImageUrl;

    @Column(name = "thumbnail_profile_image_url",length = 2047)
    private String thumbnailImageUrl;

    @OneToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
    private User user;

}
