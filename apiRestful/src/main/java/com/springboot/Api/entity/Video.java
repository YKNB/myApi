package com.springboot.Api.entity;

import com.springboot.Api.security.service.UserDetailsServiceImpl;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private User uploader;
    @Column(name="original_FileName", nullable = false)
    private String originalFileName;


    @Column(name="created_date", nullable = false)
    private Timestamp createdDate;

    @Column
    private String title;

    @Column
    private Long views = 0L;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViews(Long views) { this.views = views; }

    @Builder
    public Video(User uploader, String originalFileName, Timestamp createdDate, String title) {
        this.uploader = uploader;
        this.originalFileName = originalFileName;
        this.createdDate = createdDate;
        this.title = title;
    }
}
