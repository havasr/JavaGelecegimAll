package model;

public class Category {

    private String categoryName;

    private int filmCount = 0;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getFilmCount() {
        return filmCount;
    }

    public void setFilmCount(int filmCount) {
        this.filmCount = filmCount;
    }

    public void incrementFilmCount() {
        ++filmCount;
    }

    @Override
    public String toString() {
        return "Category Name='" + categoryName + '\'' +
                ", film Count=" + filmCount;
    }

    ;
}


