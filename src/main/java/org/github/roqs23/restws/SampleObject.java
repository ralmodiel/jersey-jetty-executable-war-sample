package org.github.roqs23.restws;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName(value = "sample")
@XmlType(name = "", propOrder = { "path", "rawQuery","response" })
@XmlRootElement(name="sample")
public class SampleObject {
	private String path;
	private String rawQuery;
	private Object response;

	public SampleObject() {
		super();
	}

	public SampleObject(String path, String rawQuery, Object response) {
		super();
		this.path = path;
		this.rawQuery = rawQuery;
		this.response = response;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getRawQuery() {
		return rawQuery;
	}

	public void setRawQuery(String rawQuery) {
		this.rawQuery = rawQuery;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
