package com.netshell.test.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JavaCollectionStreamTest implements Test {

	private static class Site {
		private String siteID;
		private String siteName;

		public Site(String siteID, String siteName) {
			this.siteID = siteID;
			this.siteName = siteName;
		}

		public String getSiteID() {
			return siteID;
		}

		public String getSiteName() {
			return siteName;
		}

		@Override
		public String toString() {
			return "Site [siteID=" + siteID + ", siteName=" + siteName + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((siteID == null) ? 0 : siteID.hashCode());
			result = prime * result + ((siteName == null) ? 0 : siteName.hashCode());
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
			Site other = (Site) obj;
			if (siteID == null) {
				if (other.siteID != null)
					return false;
			} else if (!siteID.equals(other.siteID))
				return false;
			if (siteName == null) {
				if (other.siteName != null)
					return false;
			} else if (!siteName.equals(other.siteName))
				return false;
			return true;
		}

	}

	@Override
	public void execute() throws Exception {
		List<Site> siteList = getList();

		Map<String, List<Site>> groupMap = siteList.stream().collect(Collectors.groupingBy(Site::getSiteID));
		Long count = siteList.stream().collect(Collectors.counting());
		Map<String, Long> groupCount = siteList.stream().collect(Collectors.groupingBy(Site::getSiteID, Collectors.counting()));

		System.out.println(groupMap);
		System.out.println(count);
		System.out.println(groupCount);
	}

	private List<Site> getList() {
		return Arrays.asList(new Site("S1", "Site1"), new Site("S2", "Site2"), new Site("S3", "Site3"),
				new Site("S2", "Site5"),
				new Site("S3", "Site6"));
	}
	
	private static class CustomCollector implements Collector<Integer, String, Exception> {

		@Override
		public BiConsumer<String, Integer> accumulator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Set<java.util.stream.Collector.Characteristics> characteristics() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public BinaryOperator<String> combiner() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Function<String, Exception> finisher() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Supplier<String> supplier() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
