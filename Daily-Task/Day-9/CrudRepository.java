import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, ID> {

    void save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    boolean update(ID id, T entity);

    boolean deleteById(ID id);
}