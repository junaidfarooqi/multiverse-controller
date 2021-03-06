package io.nms.central.microservice.topology.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class Face {
	
	public enum SchemeEnum {
		ether("ether");

		private String value;
		private SchemeEnum(String value) { this.value = value; }
		public String getValue() { return this.value; }
	};
		
	// in SQL table
		// common fields
	private int id;
	private String label;
	private String created;
	private String updated;
	private String status = "DOWN";
	
	// face fields
	private String local;
	private String remote;
	private SchemeEnum scheme;
	private int vctpId;
	private int vlinkConnId;
	private int vnodeId;
	
	
	/*-----------------------------------------------*/
	public Face() {}
	
	public Face(int id) {
		this.id = id;
	}
	
	public Face(JsonObject json) {
	    FaceConverter.fromJson(json, this);
	}
	
	public JsonObject toJson() {
		JsonObject json = new JsonObject();
		FaceConverter.toJson(this, json);
		return json;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Face) obj).id);
	}

	@Override
	public String toString() {
		return this.toJson().encodePrettily();
	}
	
	
	
	/*-----------------------------------------------*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getRemote() {
		return remote;
	}

	public void setRemote(String remote) {
		this.remote = remote;
	}

	public SchemeEnum getScheme() {
		return scheme;
	}

	public void setScheme(SchemeEnum scheme) {
		this.scheme = scheme;
	}

	public int getVctpId() {
		return vctpId;
	}

	public void setVctpId(int vctpId) {
		this.vctpId = vctpId;
	}

	public int getVlinkConnId() {
		return vlinkConnId;
	}

	public void setVlinkConnId(int vlinkConnId) {
		this.vlinkConnId = vlinkConnId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getVnodeId() {
		return vnodeId;
	}

	public void setVnodeId(int vnodeId) {
		this.vnodeId = vnodeId;
	}
	
}
