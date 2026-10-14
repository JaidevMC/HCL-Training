import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class InMemoryRepository<T, ID>
        implements CrudRepository<T, ID> {

    private final Map<ID, T> data = new HashMap<>();
    private final Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T entity) {
        ID id = idExtractor.apply(entity);
        data.put(id, entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public boolean update(ID id, T entity) {
        if (!data.containsKey(id)) {
            return false;
        }

        ID entityId = idExtractor.apply(entity);

        if (!id.equals(entityId)) {
            return false;
        }

        data.put(id, entity);
        return true;
    }

    @Override
    public boolean deleteById(ID id) {
        return data.remove(id) != null;
    }
}