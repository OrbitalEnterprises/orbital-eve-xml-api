package enterprises.orbital.impl.evexmlapi.utils;

public class DateUtils {
	public static GMTConverter getGMTConverter() {
		return new GMTConverter("yyyy-MM-dd HH:mm:ss");
	}
}