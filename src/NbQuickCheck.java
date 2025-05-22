import java.util.List;
import java.util.Map;

public class NbQuickCheck +
{

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) 
  {
    //base case, tree is null or tree (map) so contains no root
    if (tree == null || !tree.containsKey(root))
    {
      //return 
      return;
    }
    //preorder so traverse but visit before the children
   System.out.println(root);

   //get the children of the root
   //move in the data map with variable node enter key tree and value root
   for(Integer node : tree.get(root))
   {
    //recurse. visit the children and below
    preOrder(tree, node);
   }
  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) 
  {
    //if root is null return Integer.MAX_VALUE 
    if (root == null)
    {
      return Integer.MAX_VALUE;
    }

    //set root value to min
    //this part held me up a bit
    //this was something ive knwoen just forgot 
    int min = root.value;

    for (Node<Integer> node : root.children)
    {
      //min in the child
      //this part made me overthink a bit as well
      //it makes sense after
      int minChild = minVal(node); 

      //if minchild is less than root / min 
      if(minChild < min)
      {
        //update
        min = minChild;
      }
    }


    return min;
  }
  
}
