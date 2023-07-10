package model;

import java.util.ArrayList;
import java.util.List;

public class Film {

    private String name;
    private int year;
    private String director;
    private double imdb;
    private ArrayList<Category> categoryArrayList = new ArrayList<>();
    private List<String> screenTime;
    private ArrayList<Platform> platformArrayList = new ArrayList<>();


    public Film(String name, int year, String director, double imdb, List<String> screenTime, ArrayList<Category> categoryArrayList, ArrayList<Platform> platformArrayList) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.imdb = imdb;
        this.screenTime = screenTime;
        this.categoryArrayList = categoryArrayList;
        this.platformArrayList = platformArrayList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getImdb() {
        return imdb;
    }

    public void setImdb(double imdb) {
        this.imdb = imdb;
    }


    public List<String> getScreenTime() {
        return screenTime;
    }

    public void setScreenTime(List<String> screenTime) {
        this.screenTime = screenTime;
    }

    public ArrayList<Category> getCategoryArrayList() {
        return categoryArrayList;
    }

    public void setCategoryArrayList(ArrayList<Category> categoryArrayList) {
        this.categoryArrayList = categoryArrayList;
    }

    public ArrayList<Platform> getPlatformArrayList() {
        return platformArrayList;
    }

    public void setPlatformArrayList(ArrayList<Platform> platformArrayList) {
        this.platformArrayList = platformArrayList;
    }

    @Override
    public String toString() {
        return "Name= " + name + "\n" +
                "Year = " + year + "\n" +
                "Director = '" + director + "\n" +
                "Imdb Rating= " + imdb + "\n" +
                "Category = " + categoryArrayList + "\n" +
                "Screening Time = '" + screenTime + "\n" +
                "Platform = " + platformArrayList + "\n" +
                "--------------------------------------------";
    }
}
