package chapter_4;

public class BinarySearchTree<AnyType> {
	private BinaryNode<AnyType> root;

	private static class BinaryNode<AnyType> {

		AnyType element;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;

		BinaryNode(AnyType e) {
			this(e, null, null);
		}

		BinaryNode(AnyType e, BinaryNode left, BinaryNode right) {
			this.element = e;
			this.left = left;
			this.right = right;
		}
	}

	public BinarySearchTree() { // ??
		root = null;
	}

	public BinarySearchTree(AnyType r) {
		root = new BinaryNode(r);
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	/*
	 * why make this? when we use method contains BinarySearchTree
	 * Object.contains(x) no need to input root
	 */
	public boolean contains(AnyType x) {
		return contains(x, root);
	}

	public AnyType findMin() {
		if (isEmpty()) {
			throw new IllegalArgumentException();
		}
		return findMin(root).element;
	}

	public AnyType findMax() {
		if (isEmpty()) {
			throw new IllegalArgumentException();
		}
		return findMax(root).element;
	}

	public void insert(AnyType x) {
		root = insert(x, root);
	}

	public void remove(AnyType x) {
		root = remove(x, root);
	}

	public void printTree() {
	}

	private <AnyType extends Comparable> boolean contains(AnyType x, BinaryNode<AnyType> t) { // 声明泛型参数类型实现Comparable接口！！！
		if (t == null) {
			throw new IllegalArgumentException();
		}
		int compareResult = x.compareTo(t.element);

		if (compareResult < 0) {
			return contains(x, t.left);
		}
		else if (compareResult > 0) {
			return contains(x, t.right);
		}
		else {
			return true;
		}
	}

	// why return BinaryNode ? why need another private method??
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {  // use recursive function
		if(t == null) {
			throw new IllegalArgumentException();
		}
		if(t.left != null) {
			return findMin(t.left);
		}
		else {
			return t;
		}
	}

	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
		if(t == null) {
			throw new IllegalArgumentException();
		}
		while(t.right != null) {
			t = t.right;
		}
		return t;
		
	}

	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
		if(t == null) {
			return new BinaryNode(x);
		}
		
	}

	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
	}

	private void printTree(BinaryNode<AnyType> t) {
	}

}
