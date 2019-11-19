
/**
 * Write a description of interface TernaryTree here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface TernaryTree<E extends Comparable<E>>
{
     public TernaryTree<E> leftSubTree();
     
     public TernaryTree<E> midSubTree();
     
     public TernaryTree<E> rightSubTree();
     
     public void insertMany(E val, int n);
     
     public void removeDuplicates(E val);
     
     public boolean isEmpty();
}
