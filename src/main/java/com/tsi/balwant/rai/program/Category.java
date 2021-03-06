package com.tsi.balwant.rai.program;



import javax.persistence.*;


@Entity
@Table(name="category")
public class Category {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    String name;



    //Constructors
    public Category(int categoryId, String name){
        this.categoryId = categoryId;
        this.name = name;
    }
    public Category(){}

    //Methods
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}