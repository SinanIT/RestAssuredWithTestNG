package dataShare;

import java.util.LinkedHashMap;

public class ThreadLOcalDataStoreAsMap {
	private ThreadLOcalDataStoreAsMap() {};
	
	//private static LinkedHashMap<String, Object> dataMap = new LinkedHashMap<String, Object>();
	
	private static ThreadLocal<LinkedHashMap<String, Object>> dataMap = ThreadLocal.withInitial(() -> new LinkedHashMap<String, Object>());
	
	public static  void setValue(String key, Object value) {
		dataMap.get().put(key, value);
	}
	
	public static Object getValue(String key) {
		return dataMap.get().get(key);
		
	}

}
