package ro.teamnet.zth.api.em;

import java.util.List;

/**
 * Created by Alexandru.Dinca on 7/8/2016.
 */
public interface EntityManager {

    <T> T findById(Class<T> entityClass, Long id);

    public void getNextIdVal(String tableName, String columnIdName);

    <T> Object insert(T entity);

    <T> List<T> findAll(Class<T> entityClass);

}
