import model.Category;
import model.Film;
import model.Platform;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Film> FilmList = new ArrayList<>();
        ArrayList<Category> categoryList = new ArrayList<>();
        ArrayList<Platform> platformList = new ArrayList<>();
        List<String> screeningsList = new ArrayList<>();
        List<Category> filmCategories = new ArrayList<>();
        List<Platform> filmPlatforms = new ArrayList<>();

        String user;
        int entry;
        boolean ask = true;


        do {
            System.out.println("Welcome! Please enter 'A' if you are an Admin, please enter 'C' if you are a Client. Enter 'X' for exit.");
            Scanner input = new Scanner(System.in);
            user = input.next();

            switch (user) {
                case "A":
                    System.out.println("Welcome Admin!");
                    System.out.println("Please choose to Enter: 1-Category 2-Platform 3-Film");
                    entry = input.nextInt();
                    input.nextLine();

                    switch (entry) {
                        case 1:

                            System.out.println("Please enter the following information.");

                            System.out.println("Name of the Category:");
                            String newCategoryName = input.nextLine();
                            Category newCategory = new Category();
                            newCategory.setCategoryName(newCategoryName);
                            categoryList.add(newCategory);

                            break;

                        case 2:
                            System.out.println("Name of the Platform:");
                            String newPlatformName = input.nextLine();
                            Platform newPlatform = new Platform();
                            newPlatform.setPlatformName(newPlatformName);
                            platformList.add(newPlatform);

                            break;

                        case 3:

                            System.out.println("Name of the film:");
                            String name = input.nextLine();

                            System.out.println("Year of the film:");
                            int year = input.nextInt();
                            input.nextLine();

                            System.out.println("Director of the film:");
                            String director = input.nextLine();

                            System.out.println("Imdb rating of the film:");
                            double imdb = input.nextDouble();
                            input.nextLine();

                            System.out.print("Enter the number of screeningsList for this film: ");
                            int n;
                            n = input.nextInt();
                            input.nextLine();

                            System.out.println("Screening time of the film:");
                            for (int i = 0; i < n; i++) {
                                System.out.println("Screening-" + (i + 1) + ": ");
                                String screening = input.next();
                                screeningsList.add(screening);
                            }

                            System.out.print("Enter the number of categories for this film: ");
                            int c;
                            c = input.nextInt();
                            input.nextLine();

                            System.out.println("Choose categories for the film.");
                            for (int i = 0; i < categoryList.size(); i++) {
                                System.out.println((i + 1) + "-" + categoryList.get(i).getCategoryName());
                            }
                            for (int i = 0; i < c; i++) {
                                System.out.println("Category-" + (i + 1) + ": ");
                                int catNum = input.nextInt();
                                input.nextLine();
                                filmCategories.add(categoryList.get(catNum - 1));

                            }


                            System.out.print("Enter the number of platforms for this film: ");
                            int p;
                            p = input.nextInt();
                            input.nextLine();

                            System.out.println("Choose platforms for the film.");
                            for (int i = 0; i < platformList.size(); i++) {
                                System.out.println((i + 1) + "-" + platformList.get(i).getPlatformName());
                            }
                            for (int i = 0; i < p; i++) {
                                System.out.println("Platform-" + (i + 1) + ": ");
                                int platNum = input.nextInt();
                                input.nextLine();
                                filmPlatforms.add(platformList.get(platNum - 1));

                            }

                            Film newFilm = new Film(name, year, director, imdb, screeningsList, categoryList, platformList);
                            FilmList.add(newFilm);


                    }

                    break;

                case "C":
                    System.out.println("Welcome!");
                    System.out.println("Please enter the category you want to see.");
                    for (int i = 0; i < categoryList.size(); i++) {
                        System.out.println((i + 1) + "-" + categoryList.get(i).getCategoryName());
                    }
                    int userCat = input.nextInt();
                    input.nextLine();

                    System.out.println("Films in category '" + categoryList.get(userCat - 1).getCategoryName() + "':");
                    for (Film film : FilmList) {
                        for (Category category : film.getCategoryArrayList()) {
                            if (category.getCategoryName().equals(categoryList.get(userCat - 1).getCategoryName())) {
                                System.out.println(film);
                            }
                        }
                    }

                    break;
                case "X":
                    System.out.println("You are exiting.");
                    ask = false;
                    break;

                default:
                    System.out.println("Wrong input please re-enter.");
                    break;
            }

        } while (ask);

    }
}