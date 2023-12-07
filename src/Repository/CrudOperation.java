package Repository;

import java.sql.Connection;
import java.util.List;

public interface CrudOperation <T> {

    public List<T> findAll();
    public T findById(int id);

   public T save(T toSave);
    public List<T> saveAll(List<T>  toSave);
    public  T update (T toUpdate);

}
