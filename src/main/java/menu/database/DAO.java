package menu.database;


import java.util.ArrayList;

public interface DAO<T> {

        T get(int id);

        ArrayList<T> getAll();

        boolean delete(int id);

        boolean addPlane(T t);



    }

