
/**
 * Utilizes BinarySearchTree and displays its properties.
 *
 * @author Sena Yevenyo
 * @version October 27, 2019
 */
public class SimulationController
{
    // instance variables - replace the example below with your own
    private BinarySearchTree<Integer> treeBST = new BinarySearchTree<Integer>();

    /**
     * Constructor for objects of class ExperimentController
     */
    public SimulationController()
    {
        // initialise instance variables
        
    }
    
    /**
     * Runs the program for the lab
     * @param arguments to run the program
     */
    public static void main(String[] args){
        BinarySearchTree<Integer> treeBST = new BinarySearchTree<Integer>();
        System.out.println("Inserting values");
        System.out.println("==============================");
        System.out.println();
        for(int i=0;i<args.length;i++){
            System.out.print("Insert "+args[i]+": ");
            System.out.println("Insertion completion: "+treeBST.insert(Integer.parseInt(args[i])));
        }
        System.out.println();
        
        System.out.println("Print tree");
        System.out.println("==============================");
        System.out.println();
        System.out.println("In-order String: "+treeBST.inOrderString());
        System.out.println("Post-order String: "+treeBST.postOrderString());
        System.out.println("Pre-order String: "+treeBST.preOrderString());
        System.out.println();
        
        System.out.println("Largest element in tree");
        System.out.println("==============================");
        System.out.println(treeBST.findMax());
        System.out.println();
        
        System.out.println("Smallest element in tree");
        System.out.println("==============================");
        System.out.println(treeBST.findMin());
        System.out.println();
        
        System.out.println("Number of elements at each depth");
        System.out.println("==============================");
        for(int i=treeBST.getHeight();i>=0;i--){
            System.out.println("Number of elements at depth "+i+": "+treeBST.numOfElementsDepth(i));
        }
        System.out.println();
        
        System.out.println("Empty tree");
        System.out.println("==============================");
        treeBST.empty();
        System.out.println("Tree emptied");
        System.out.println("Is tree empty? "+treeBST.isEmpty());
        System.out.println("In-order String: "+treeBST.inOrderString());
        System.out.println("Post-order String: "+treeBST.postOrderString());
        System.out.println("Pre-order String: "+treeBST.preOrderString());
        System.out.println();
    }
}
