package com.dataflowdeveloper;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author tspann
 *
 */
public class SoupService {

	private static String trim(String s, int width) {
		if (s.length() > width)
			return s.substring(0, width - 1) + ".";
		else
			return s;
	}

	/**
	 * extract links from an HTML file in URL
	 *
	 * @param url
	 * @return Link List
	 */
	public List<PrintableLink> extract(String url, String type) {
		List<PrintableLink> linksReturned = new ArrayList<>();

		try {
			Document doc = Jsoup.connect(url).get();
			Elements links = doc.select("a[href]");
			PrintableLink pLink = null;
 
			for (Element link : links) {
				if (null != type) {
					if (null != link.attr("abs:href") && link.attr("abs:href").endsWith(type)) {
						pLink = new PrintableLink();
						pLink.setLink(link.attr("abs:href"));
						pLink.setDescr(trim(link.text(), 100));
						linksReturned.add(pLink);
						pLink = null;
					}
				} else {
					pLink = new PrintableLink();
					pLink.setDescr(link.attr("abs:href"));
					pLink.setLink(trim(link.text(), 100));
					linksReturned.add(pLink);
					pLink = null;
				}
			}
		} catch (Exception x) {
			x.printStackTrace();
		}
		return linksReturned;
	}

}