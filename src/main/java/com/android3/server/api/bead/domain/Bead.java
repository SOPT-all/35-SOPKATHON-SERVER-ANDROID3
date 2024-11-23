package com.android3.server.api.bead.domain;

import com.android3.server.api.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Bead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String content1;

    private String content2;

    private boolean checked;

    public Bead(User user, String content1, String content2, boolean checked) {
        this.user = user;
        this.content1 = content1;
        this.content2 = content2;
        this.checked = checked;
    }

}
