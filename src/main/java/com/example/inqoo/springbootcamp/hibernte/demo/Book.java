package com.example.inqoo.springbootcamp.hibernte.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ISBN;
    private Integer edition;
    private String title;
    private LocalDate editionDate;
    private String coverType;
    private Integer pageCount;

    public Book (){
    }

    public Book(String ISBN, Integer edition, String title, LocalDate editionDate, String coverType, Integer pageCount) {
        this.ISBN = ISBN;
        this.edition = edition;
        this.title = title;
        this.editionDate = editionDate;
        this.coverType = coverType;
        this.pageCount = pageCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDate editionDate) {
        this.editionDate = editionDate;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", ISBN='" + ISBN + '\'' +
                ", edition=" + edition +
                ", title='" + title + '\'' +
                ", editionDate=" + editionDate +
                ", coverType='" + coverType + '\'' +
                ", pageCount=" + pageCount +
                '}';
    }

}
