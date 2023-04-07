import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind<T> 
{
    private Map<T, T> parent;
    private Map<T, Integer> rank;

    public UnionFind(List<T> list) 
    {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for (T item : list)
        {
            parent.put(item, item);
            rank.put(item, 0);
        }
    }

    public T find(T item) 
    {
        if (parent.get(item) == item) 
        {
            return item;
        }
        T newParent = find(parent.get(item));
        parent.put(item, newParent);
        return newParent;
    }

    public void union(T x, T y)
    {
        T rootX = find(x);
        T rootY = find(y);
        if (rootX == rootY) 
        {
            return;
        }
        if (rank.get(rootX) < rank.get(rootY))
        {
            parent.put(rootX, rootY);
        } else if (rank.get(rootX) > rank.get(rootY))
        {
            parent.put(rootY, rootX);
        } else
        {
            parent.put(rootY, rootX);
            rank.put(rootX, rank.get(rootX) + 1);
        }
    }

    public boolean connected(T x, T y) 
    {
        return find(x) == find(y);
    }
}
