package com.dataflowdeveloper;

import java.io.Serializable;

public class PrintableLink implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 4055063817022673520L;
	private String link;
	private String descr;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [link=");
		builder.append(link);
		builder.append(", descr=");
		builder.append(descr);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * @param link
	 * @param descr
	 */
	public PrintableLink(String link, String descr) {
		super();
		this.link = link;
		this.descr = descr;
	}
	/**
	 *
	 */
	public PrintableLink() {
		super();
	}
	/**
	 * @param link
	 */
	public PrintableLink(String link) {
		super();
		this.link = link;
	}




}
