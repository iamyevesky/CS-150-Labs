/**
 * Represents the edge of a graph with 'one vertex, another vertex' representation
 *
 * @author Sena Yevenyo
 * @version Monday, November 18 2019
 */
public class NamedEdge implements Comparable<NamedEdge>
{
    // instance variables - replace the example below with your own
    private String name1;
    private String name2;
    private float weight;
    /**
     * Constructor for objects of class NamedEdge
     * @param first - Field name for 'one Vertex'
     * @param second - Field name for 'another Vertex'
     * @param weight - Field name for weight
     */
    public NamedEdge(String first, String second, float weight)
    {
        // initialise instance variables
        name1 = first;
        name2 = second;
        this.weight = weight;
    }

    /**
     * Sets the value of first String field name (one Vertice)
     * @param name- the new name for the 'one Vertice'
     */
    public void setName1(String name)
    {
        // put your code here
        name1 = name;
    }
    
    /**
     * Gets the value of first String field name (one Vertice)
     * @return the name for the 'one Vertice'
     */
    public String getName1()
    {
        // put your code here
        return name1;
    }
    
    /**
     * Sets the value of second String field name (another Vertice)
     * @param name - the new name for the 'another Vertice'
     */
    public void setName2(String name)
    {
        // put your code here
        name2 = name;
    }
    
    /**
     * Gets the value of second String field name (another Vertice)
     * @return the name for the 'another Vertice'
     */
    public String getName2()
    {
        // put your code here
        return name2;
    }
    
    /**
     * Sets the weight of an edge
     * @param value - the new weight for an edge
     */
    public void setWeight(float value){
        weight = value;
    }
    
    /**
     * Gets the weight of an edge
     * @return the weight for an edge
     */
    public float getWeight(){
        return weight;
    }
    
    public int compareTo(NamedEdge that){
        if(this.getWeight()>that.getWeight()) return 1;
        else if(this.getWeight()<that.getWeight()) return -1;
        else return 0;
    }
}
