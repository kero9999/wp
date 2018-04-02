package wp_system_service;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class TestMD5 {
	@Test
	public void testMd5(){
		System.out.println(DigestUtils.md5Hex("123456"));
	}
}
