package temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 길찾기게임 {

	private static int index;

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };
		solution(nodeinfo);
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		List<Tree> list = new ArrayList<Tree>();

		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new Tree(nodeinfo[i][0], nodeinfo[i][1], i + 1));
		}
		
		Collections.sort(list, new Comparator<Tree>() {
			@Override
			public int compare(Tree o1, Tree o2) {
				int com = o2.y - o1.y;
				if(com == 0) {
					com = o1.x - o2.x;
				}
				return com;
			}
		});
		
		Tree root = list.get(0);
		for(int i=1; i<list.size(); i++) {
			add(root, list.get(i));
		}
		
		answer = new int[2][list.size()];
		index = 0;
		preorder(answer, root);
		index = 0;
		postorder(answer, root);
		
		return answer;
	}
	
	public static void preorder(int[][] ans, Tree root) {
		if(root != null) {
			ans[0][index++] = root.data;
			preorder(ans, root.left);
			preorder(ans, root.right);
		}
	}
	
	public static void postorder(int[][] ans, Tree root) {
		if(root != null) {
			postorder(ans, root.left);
			postorder(ans, root.right);
			ans[1][index++] = root.data;
		}
	}
	
	public static void add(Tree root, Tree child) {
		if(root.x > child.x) {
			if(root.left == null) {
				root.left = child;
			} else {
				add(root.left, child);
			}
		} else {
			if(root.right == null) {
				root.right = child;
			} else {
				add(root.right, child);
			}
		}
	}

	static class Tree{
		int x;
		int y;
		int data;
		Tree left;
		Tree right;

		Tree(int x, int y, int data) {
			this.x = x;
			this.y = y;
			this.data = data;
		}

		@Override
		public String toString() {
			return x + ", " + y + " : " + data +"\n";
		}
	}
}
