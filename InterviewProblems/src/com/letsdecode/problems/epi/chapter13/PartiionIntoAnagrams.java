package com.letsdecode.problems.epi.chapter13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PartiionIntoAnagrams {
	class KeyValue {
		String key;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			KeyValue other = (KeyValue) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}

		String value;

		public KeyValue(String value) {
			this.value = value;
			char[] a = value.toCharArray();
			Arrays.sort(a);
			this.key = new String(a);
		}
	}

	String getKey(String value) {
		char[] a = value.toCharArray();
		Arrays.sort(a);
		return new String(a);

	}

	private HashMap<String, List<String>> map = new HashMap<>();

  
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String v : strs) {
			String key = getKey(v);
			List<String> list = map.get(key);
			if (list == null) {
				list = new ArrayList<>();
				map.put(key, list);
			}
			list.add(v);
		}
		List<List<String>> out  = new ArrayList<>();
		Set<String> keySet = map.keySet();
		ArrayList<String> keyList= new ArrayList<>();
		keyList.addAll(keySet);
		Collections.sort(keyList);
		for (String k : keyList) {
			
			List<String> l = map.get(k);
			Collections.sort(l);
			out.add(l);
		}
		return out;
        
    }

}
