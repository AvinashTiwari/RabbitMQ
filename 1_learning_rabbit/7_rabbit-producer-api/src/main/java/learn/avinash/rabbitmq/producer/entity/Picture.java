package learn.avinash.rabbitmq.producer.entity;

public class Picture {

	private String name;
	private String source;
	private String type;
	private long size; 

	public String getName() {
		return name;
	}

	public long getSize() {
		return size;
	}

	public String getSource() {
		return source;
	}

	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Picture [name=" + name + ", source=" + source + ", type=" + type + ", size=" + size + "]";
	}

}
