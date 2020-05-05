package util;

public class StringUtil {

	public static String getArrayToString(String[] strs) {
		StringBuilder sb = new StringBuilder("");
		if (strs != null) {
			int len = strs.length;
			for (int i = 0; i < len - 1; i++) {
				sb.append(strs[i]);
				sb.append(":");
			}
			sb.append(strs[len - 1]);
		}
		return sb.toString();
	}

}
