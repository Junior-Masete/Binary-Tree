public class StandardBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {
    @Override
    public void depthFirstTraversal() {
        depthFirstTraversal(root);
    }

    protected void depthFirstTraversal(Leaf<T> node){
        if(node != null){
            
            depthFirstTraversal(node.left);
            System.out.println(node.toString());
            node.toString();
            depthFirstTraversal(node.right);
        }
    }

    @Override
    public int numLeavesInTree() {
        if(root == null){
            return 0;
        }
        else{
            return numLeavesInTree(root);
        }  
       
    }

    protected int numLeavesInTree(Leaf<T> node){
        if(node == null){
            return 0;
        }
        else{
            return numLeavesInTree(node.left) + numLeavesInTree(node.right) + 1;
        }
    }

    @Override
    public int height() {
        if(root == null){
            return 0;
        }
        else{
            return height(root);
        }
    }

    protected int height(Leaf<T> node){
        if(node == null){
            return -1;
        }
        else{
            int leftH = height(node.left);
            int rightH = height(node.right);

            if(leftH > rightH){
                return leftH + 1;
            }
            else{
                return rightH + 1;
            }
        }
    }

    @Override
    public Leaf<T> findParent(T data) {
        if(root == null){
            return null;
        }
        else if(root.data.compareTo(data) == 0){
            //System.out.println("yES I GOT HERE");
            System.out.println(root.toString());
            //System.out.println("[" + root.data +"]");
            return null;
        }
        else{
            Leaf<T> prev = null;
            findParent(root, prev, data);
            return prev;
        }
    }

    private Leaf<T> findParent(Leaf<T> node,Leaf<T> prev, T data){
        
        if(node == null){
            return null;
        }


        if(node.data.compareTo(data) == 0){
            //System.out.println(node.toString());
            return node;
        }
        else if(node.data.compareTo(data) > 0){
            System.out.println(node.toString());
            prev = node;
            return findParent(node.left,node, data);
        }
        else{
            System.out.println(node.toString());
            prev = node;
            return findParent(node.right,node, data);
        }
    }

    @Override
    public void insert(T data) {
        super.insert(data, true);
        
    }

    @Override
    public Leaf<T> find(T data) {
        if(root == null){
            return null;
        }
        else{
            return find(root, data);
        }
    }

    protected Leaf<T> find(Leaf<T> node, T data){
        if(node == null){
            //System.out.println(node.toString());
            return null;
        }

        if(node.data.compareTo(data) == 0){
            System.out.println(node.toString());
            return node;
        }
        else if(node.data.compareTo(data) > 0){
            System.out.println(node.toString());
            return find(node.left, data);
        }
        else{
            System.out.println(node.toString());
            return find(node.right, data);
        }


    }

    @Override
    public boolean perfectlyBalanced() {


        Leaf<T> leftOfroot = root.left;
        Leaf<T> rigthtOfroot = root.right;
        int lh = numLeavesInTree(leftOfroot);
        int rh = numLeavesInTree(rigthtOfroot);
        if(lh == rh){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public boolean contains(T data) {
        if(root == null){
            return false;
        }
        
        Leaf<T> nnode = contains(root, data);
        if(nnode != null){
            return true;
        }
        else{
            return false;
        }

    }

    protected Leaf<T> contains(Leaf<T> node,T data){
        if(node == null){
            
            return null;
        }

        if(node.data.compareTo(data) == 0){
            System.out.println(node.toString());
            return node;
        }
        else if(node.data.compareTo(data) > 0){
            System.out.println(node.toString());
            return find(node.left, data);
        }
        else{
            System.out.println(node.toString());
            return find(node.right, data);
        }
    }

    @Override
    public BinaryTree<T> convertTree() {

        if(root == null){
            return null;
        }
        else{
            BinaryTree<T> tr = new MirroredBinaryTree<>();
            tr.root = root;
            mirror(tr.root);
            return tr;
        }

        
    }

    private Leaf<T> mirror(Leaf<T> node){
        if(node == null){
            return null;
        }

        Leaf<T> left = mirror(node.left);
        Leaf<T> right = mirror(node.right);

        node.left = right;
        node.right = left;
        return node;
    }

}
