// No.71
// tricky

package string;

import java.util.Stack;

public class SimplifyPath {
	public static String simplifyPath(String path) {
        String[] sp = path.split("/");
		if (sp.length == 0) {
			return "/";
		}
		Stack<String> st = new Stack<String>();
		for (int i = 0; i < sp.length; i++) {
			if (!sp[i].equals("")) {
				if (!sp[i].equals(".") && !sp[i].equals("..")) {
					st.push(sp[i]);
				} else if (!sp[i].equals(".") && !st.isEmpty()) {
					st.pop();
				}
			}
		}

		StringBuilder res = new StringBuilder();
		if (st.isEmpty()) {
			res.append("/");
		} else {
			while (!st.isEmpty()) {
				res.insert(0, st.pop());
				res.insert(0, "/");
			}
		}
		return res.toString();   
    }
	
	// this solution fails
	public static String simplify(String path) {
		if (path == null || path.length() == 0) {
			return path;
		}
		path = path.replace("//", "/");
		for (int i = path.length() - 1; i >= 0; i++) {
			if (path.charAt(i) == ' ') {
				continue;
			} else if (path.charAt(i) == '/') {
				while (i >= 0 && path.charAt(i) == '/') {
					i--;
				}
				if (i < 0) {
					return "/";
				}
				path = path.substring(0, i + 1);
				break;
			} else {
				break;
			}
		}
		if (path.contains(".")) {
			for (int i = path.length() - 1; i >= 0; i--) {
				if (path.charAt(i) == '/') {
					path = path.substring(i, path.length());
					break;
				}
			}
		}
		if (path.contains(".")) {
			return "/";
		}
		
		return path;
	}

	public static void main(String[] args) {
		String path = "/.";
		System.out.println(simplifyPath(path));
	}

}
