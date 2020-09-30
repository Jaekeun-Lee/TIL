 
import java.util.Vector;

public class VectorReverse {

	public static Vector<String> dataChange(String[] strData) {

		StringBuffer sb = new StringBuffer();
		Vector<String> vs = new Vector<String>();

		for (String s : strData) {
			sb.append("@" + s);
		}

		sb.reverse();
		String allStr = sb.toString();
		String[] toVector = allStr.split("@");

		for (String s : toVector) {
			vs.add(s);
		}

		return vs;
	}

	public static void main(String[] args) {

		String[] strData = { "Java Programming", "JDBC", "Oracle 10g", "JSP/Servlet" };

		Vector<String> v = VectorReverse.dataChange(strData);

		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.elementAt(i));
		}

	}

}
