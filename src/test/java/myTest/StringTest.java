package myTest;

import org.junit.Assert;
import org.junit.Test;

import util.StringUtil;


public class StringTest {

	@Test
	public void testArrayToString() {
		String[] strs = {"足球","篮球","游泳"};
		String str = StringUtil.getArrayToString(strs);
		Assert.assertEquals("足球:篮球:游泳", str);
	}
}
