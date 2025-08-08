package ku.cs.demo.services;
                             //Generic Type : T, K, V, E
public interface Datasource<T> {
    T readData();
    void writeData(T data);
}
