package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String title;

    @JsonProperty
    private int year;

    public BookDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BookDto(Long id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }
}
